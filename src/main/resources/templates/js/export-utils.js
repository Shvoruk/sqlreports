export function convertToCSV(data) {
    if (!data || !data.length) return '';

    const headers = Object.keys(data[0]);

    const headerRow = headers.map(header => {
        const escaped = header.replace(/"/g, '""');
        return `"${escaped}"`;
    }).join(';');

    const dataRows = data.map(row => {
        return headers.map(header => {
            let value = row[header];

            if (value === null || value === undefined) {
                return '""';
            }

            value = value.toString();

            if (value.includes('"') || value.includes(';') || value.includes('\n')) {
                value = `"${value.replace(/"/g, '""')}"`;
            } else if (value === '') {
                value = '""';
            }

            return value;
        }).join(';');
    });

    const BOM = '\uFEFF';

    return BOM + headerRow + '\r\n' + dataRows.join('\r\n');
}

export function downloadCSV(csvContent, fileName) {
    const blob = new Blob([csvContent], {
        type: 'text/csv;charset=utf-8'
    });

    if (navigator.msSaveBlob) {
        navigator.msSaveBlob(blob, fileName);
        return;
    }

    const link = document.createElement('a');

    const url = window.URL.createObjectURL(blob);

    link.setAttribute('href', url);
    link.setAttribute('download', fileName);
    link.style.visibility = 'hidden';

    document.body.appendChild(link);

    link.click();

    document.body.removeChild(link);
    window.URL.revokeObjectURL(url);
}

export function formatColumnHeader(header) {
    return header
        .replace(/([A-Z])/g, ' $1')
        .replace(/_/g, ' ')
        .replace(/^./, str => str.toUpperCase())
        .trim();
}