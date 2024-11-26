import { convertToCSV, downloadCSV, formatColumnHeader } from './export-utils.js';

const BASE_URL = 'http://localhost:8080';

export function toggleTheme() {
    const body = document.body;
    const currentTheme = body.getAttribute('data-theme');
    if (currentTheme === 'dark') {
        body.removeAttribute('data-theme');
        localStorage.setItem('theme', 'light');
    } else {
        body.setAttribute('data-theme', 'dark');
        localStorage.setItem('theme', 'dark');
    }
}

function initializeEventListeners() {
    const themeToggleBtn = document.querySelector('.theme-toggle');
    if (themeToggleBtn) {
        themeToggleBtn.addEventListener('click', toggleTheme);
    }

    const reportTypeSelect = document.getElementById('reportType');
    const scopeSelect = document.getElementById('scope');
    const generateReportBtn = document.getElementById('generateReport');
    const generateFilteredReportBtn = document.getElementById('generateFilteredReport');

    if (reportTypeSelect) {
        reportTypeSelect.addEventListener('change', handleReportTypeChange);
    }
    if (scopeSelect) {
        scopeSelect.addEventListener('change', handleScopeChange);
    }
    if (generateReportBtn) {
        generateReportBtn.addEventListener('click', generateReport);
    }
    if (generateFilteredReportBtn) {
        generateFilteredReportBtn.addEventListener('click', generateFilteredPopulationReport);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const savedTheme = localStorage.getItem('theme') || 'light';
    if (savedTheme === 'dark') {
        document.body.setAttribute('data-theme', 'dark');
    }

    initializeEventListeners();
});

const reportTypeSelect = document.getElementById('reportType');
const subOptions = document.getElementById('subOptions');
const scopeSelect = document.getElementById('scope');
const paramValueInput = document.getElementById('paramValue');
const limitInput = document.getElementById('limit');
const generateReportBtn = document.getElementById('generateReport');
const tableContainer = document.getElementById('tableContainer');

// function handleReportTypeChange(event) {
//     const selectedType = event.target.value;
//     if (selectedType) {
//         subOptions.classList.remove('hidden');
//         updateScopeOptions(selectedType);
//     } else {
//         subOptions.classList.add('hidden');
//     }
// }
function handleReportTypeChange(event) {
    const selectedType = event.target.value;
    const filteredOptions = document.getElementById('filteredOptions');
    const regularOptions = document.getElementById('subOptions');

    if (selectedType === 'population-filtered') {
        filteredOptions.classList.remove('hidden');
        regularOptions.classList.add('hidden');
        updateFilteredScopeOptions();
        // Clear fields
        if (paramValueInput) paramValueInput.value = '';
        if (limitInput) limitInput.value = '';
    } else {
        filteredOptions.classList.add('hidden');
        regularOptions.classList.remove('hidden');
        updateScopeOptions(selectedType);
    }
}

//
function updateFilteredScopeOptions() {
    const scopeSelect = document.getElementById('filteredScope');
    scopeSelect.innerHTML = '';

    const options = ['continent', 'region', 'country'];

    options.forEach(option => {
        const optionElement = document.createElement('option');
        optionElement.value = option;
        optionElement.textContent = option.charAt(0).toUpperCase() + option.slice(1);
        scopeSelect.appendChild(optionElement);
    });
}

//
function generateFilteredPopulationReport() {
    const scope = document.getElementById('filteredScope').value;
    const url = `${BASE_URL}/population/${scope}/filtered`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => displayFilteredResults(data, scope))
        .catch(error => {
            console.error('Error fetching data:', error);
            tableContainer.innerHTML = '<p class="text-red-500">Error fetching data</p>';
        });
}

//
function displayFilteredResults(data, scope) {
    if (!data || data.length === 0) {
        tableContainer.innerHTML = '<p>No data available</p>';
        return;
    }

    const scopeTitle = scope.charAt(0).toUpperCase() + scope.slice(1);
    const resultsHTML = `
        <div class="results-header">
            <h3>Population Report by ${scopeTitle} (${data.length} entries)</h3>
            <button id="exportButton" class="export-button">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" 
                          d="M4 16v1a3 3 0 003 3h10a3 3 0 003-3v-1m-4-4l-4 4m0 0l-4-4m4 4V4" />
                </svg>
                Export CSV
            </button>
        </div>
        <table>
            <thead>
                <tr>
                    <th>${scopeTitle}</th>
                    <th>Total Population</th>
                    <th>City Population</th>
                    <th>City Population %</th>
                    <th>Rural Population</th>
                    <th>Rural Population %</th>
                </tr>
            </thead>
            <tbody>
                ${data.map(row => `
                    <tr>
                        <td>${row[scope]}</td>
                        <td>${row.totalPopulation?.toLocaleString() ?? 'N/A'}</td>
                        <td>${row.cityPopulation?.toLocaleString() ?? 'N/A'}</td>
                        <td>${row.cityPercentage ?? 'N/A'}</td>
                        <td>${row.ruralPopulation?.toLocaleString() ?? 'N/A'}</td>
                        <td>${row.ruralPercentage ?? 'N/A'}</td>
                    </tr>
                `).join('')}
            </tbody>
        </table>
    `;

    tableContainer.innerHTML = resultsHTML;

    const exportButton = document.getElementById('exportButton');
    if (exportButton) {
        exportButton.addEventListener('click', () => handleExport(data));
    }
}

function handleScopeChange(event) {
    const scope = event.target.value;
    if (scope === 'world') {
        paramValueInput.classList.add('hidden');
    } else {
        paramValueInput.classList.remove('hidden');
        paramValueInput.placeholder = `Enter ${scope} name`;
    }
}

function updateScopeOptions(reportType) {
    scopeSelect.innerHTML = '';

    let options = [];
    switch (reportType) {
        case 'capitals':
            options = ['world', 'continent', 'region'];
            break;
        case 'cities':
            options = ['world', 'continent', 'region', 'country', 'district'];
            break;
        case 'countries':
            options = ['world', 'continent', 'region'];
            break;
        case 'language':
            document.querySelectorAll('#subOptions .hidden').forEach(el => el.classList.add('hidden'));
            return;
        case 'population':
            options = ['world', 'continent', 'region', 'country', 'city', 'district'];
            break;
    }

    options.forEach(option => {
        const optionElement = document.createElement('option');
        optionElement.value = option;
        optionElement.textContent = option.charAt(0).toUpperCase() + option.slice(1);
        scopeSelect.appendChild(optionElement);
    });
}

function generateReport() {
    const reportType = reportTypeSelect.value;

    //
    if (reportType === 'population-filtered') {
        generateFilteredPopulationReport();
        return;
    }

    const scope = scopeSelect.value;
    const paramValue = paramValueInput.value;
    const limit = limitInput.value;

    let url = BASE_URL;

    switch (reportType) {
        case 'capitals':
            url += `/cities/capital/${scope}`;
            break;
        case 'cities':
            url += `/cities/${scope}`;
            break;
        case 'countries':
            url += `/countries/${scope}`;
            break;
        case 'language':
            url += '/language';
            break;
        case 'population':
            if (scope === 'world') {
                url += '/population/world';
            } else {
                url += `/population/${scope}`;
            }
            break;
    }

    if (scope !== 'world' && reportType !== 'language') {
        url += `?${scope}=${paramValue}`;
        if (limit) {
            url += `&limit=${limit}`;
        }
    } else if (limit && reportType !== 'language') {
        url += `?limit=${limit}`;
    }

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => displayResults(data))
        .catch(error => {
            console.error('Error fetching data:', error);
            tableContainer.innerHTML = '<p class="text-red-500">Error fetching data</p>';
        });
}

function handleExport(data) {
    if (!data || data.length === 0) {
        showNotification('No data to export', 'error');
        return;
    }

    const reportType = document.getElementById('reportType').value;
    const scope = reportType === 'population-filtered'
        ? document.getElementById('filteredScope').value
        : document.getElementById('scope').value;
    const timestamp = new Date().toISOString().slice(0, 19).replace(/[:-]/g, '');
    const fileName = `${reportType}-${scope}-${timestamp}.csv`;

    try {
        const formattedData = data.map(item => {
            const formattedItem = {};
            for (const [key, value] of Object.entries(item)) {
                if (typeof value === 'number') {
                    formattedItem[key] = value.toLocaleString();
                } else {
                    formattedItem[key] = value;
                }
            }
            return formattedItem;
        });

        const csvContent = convertToCSV(formattedData);
        downloadCSV(csvContent, fileName);

        showNotification('Data exported successfully!');
    } catch (error) {
        console.error('Export error:', error);
        showNotification('Error exporting data', 'error');
    }
}

function displayResults(data) {
    if (!data || data.length === 0) {
        tableContainer.innerHTML = '<p>No data available</p>';
        return;
    }

    const headers = Object.keys(data[0]);

    const resultsHTML = `
        <div class="results-header">
            <h3>Results (${data.length} entries)</h3>
            <button id="exportButton" class="export-button" ${data.length === 0 ? 'disabled' : ''}>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" 
                          d="M4 16v1a3 3 0 003 3h10a3 3 0 003-3v-1m-4-4l-4 4m0 0l-4-4m4 4V4" />
                </svg>
                Export CSV
            </button>
        </div>
        <table>
            <thead>
                <tr>
                    ${headers.map(header =>
        `<th>${formatColumnHeader(header)}</th>`
    ).join('')}
                </tr>
            </thead>
            <tbody>
                ${data.map(row => `
                    <tr>
                        ${headers.map(header => {
        const value = row[header];

        const displayValue = typeof value === 'number'
            ? value.toLocaleString()
            : (value ?? 'N/A');
        return `<td>${displayValue}</td>`;
    }).join('')}
                    </tr>
                `).join('')}
            </tbody>
        </table>
    `;

    tableContainer.innerHTML = resultsHTML;

    const exportButton = document.getElementById('exportButton');
    if (exportButton) {
        exportButton.addEventListener('click', () => handleExport(data));
    }
}

function showNotification(message, type = 'success') {
    const notification = document.createElement('div');
    notification.className = `notification ${type}`;
    notification.textContent = message;

    document.body.appendChild(notification);

    setTimeout(() => notification.classList.add('show'), 100);

    setTimeout(() => {
        notification.classList.remove('show');
        setTimeout(() => notification.remove(), 300);
    }, 3000);
}

function formatHeader(header) {
    return header
        .split(/(?=[A-Z])/)
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(' ');
}