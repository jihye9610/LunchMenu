window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const lunchtbl = document.getElementById('lunchtbl');
    if (lunchtbl) {
        new simpleDatatables.DataTable(lunchtbl);
    }
});
