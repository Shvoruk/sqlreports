const BASE_URL = 'http://localhost:8080';

// Add theme toggle functionality
function toggleTheme() {
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

// Load saved theme preference
document.addEventListener('DOMContentLoaded', () => {
    const savedTheme = localStorage.getItem('theme') || 'light';
    if (savedTheme === 'dark') {
        document.body.setAttribute('data-theme', 'dark');
    }

    reportTypeSelect.addEventListener('change', handleReportTypeChange);
    scopeSelect.addEventListener('change', handleScopeChange);
    generateReportBtn.addEventListener('click', generateReport);
});

const reportTypeSelect = document.getElementById('reportType');
const subOptions = document.getElementById('subOptions');
const scopeSelect = document.getElementById('scope');
const paramValueInput = document.getElementById('paramValue');
const limitInput = document.getElementById('limit');
const generateReportBtn = document.getElementById('generateReport');
const tableContainer = document.getElementById('tableContainer');

function handleReportTypeChange(event) {
    const selectedType = event.target.value;
    if (selectedType) {
        subOptions.classList.remove('hidden');
        updateScopeOptions(selectedType);
    } else {
        subOptions.classList.add('hidden');
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

function displayResults(data) {
    if (!data || data.length === 0) {
        tableContainer.innerHTML = '<p>No data available</p>';
        return;
    }

    const headers = Object.keys(data[0]);

    const tableHTML = `
                <table>
                    <thead>
                        <tr>
                            ${headers.map(header =>
        `<th>${formatHeader(header)}</th>`
    ).join('')}
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(row => `
                            <tr>
                                ${headers.map(header =>
        `<td>${row[header] ?? 'N/A'}</td>`
    ).join('')}
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;

    tableContainer.innerHTML = tableHTML;
}

function formatHeader(header) {
    return header
        .split(/(?=[A-Z])/)
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(' ');
}