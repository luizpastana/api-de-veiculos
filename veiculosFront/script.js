const formulario = document.querySelector(".form");
const inputModelo = document.querySelector(".modelo");
const inputPlaca = document.querySelector(".placa");
const btnCadastrar = document.getElementById("cadastrar");
const btnExibir = document.getElementById("exibir");



function cadastrar() {
    fetch("http://localhost:8080/veiculos", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            modelo: inputModelo.value,
            placa: inputPlaca.value
        })
    })
    .then(function(res) {console.log(res)})
    .catch(error => {
        console.error('Erro ao buscar os veículos:', error);
    })
};

function limpar() {
    inputModelo.value = '';
    inputPlaca.value = '';
};

function criarTabela(veiculos) {
    var tabela = document.createElement('table');
    var headerRow = tabela.insertRow();
    headerRow.insertCell(0).textContent = 'ID';
    headerRow.insertCell(1).textContent = 'Modelo';
    headerRow.insertCell(2).textContent = 'Placa';

    veiculos.forEach(veiculo => {
        var newRow = tabela.insertRow();
        newRow.insertCell(0).textContent = veiculo.id;
        newRow.insertCell(1).textContent = veiculo.modelo;
        newRow.insertCell(2).textContent = veiculo.placa;
    });

    var tabelaContainer = document.getElementById('tabelaContainer');
    tabelaContainer.innerHTML = '';
    tabelaContainer.appendChild(tabela);
}

btnCadastrar.addEventListener('click', function(e) {
    e.preventDefault();
    cadastrar();
    limpar();
});

btnExibir.addEventListener('click', function(e) {
    e.preventDefault();
    fetch("http://localhost:8080/veiculos")
    .then(response => response.json())
    .then(data => {
        criarTabela(data);
    })
    .catch(error => {
        console.error('Erro ao buscar os veículos:', error);
    });    
});