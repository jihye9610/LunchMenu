window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const lanchtbl = document.getElementById('lanchtbl');
    if (lanchtbl) {
        new simpleDatatables.DataTable(lanchtbl);
    }
});
