function validaNome(){
	let regex = /^[a-zA-Z ]{10,30}$/;
	return validaRegex('nome', regex);
}

function validaDate(){
	let regex = /^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{4}$/;
	return validaRegex('dtNascimento', regex);
}

function validaIdade(){
	let regex = /^([1-9][0-9]|100)$/;
	return validaRegex('idade', regex);
}

function validaEmail(){
	let regex = /^[a-zA-Z][a-zA-Z0-9\-\_\.]{0,}@[a-zA-Z]{2,}\.[a-z]{3}(\.[a-z]{2})?$/;
	return validaRegex('email', regex);
}

function validaCPF(){
	let regex = /^([0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}|\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2})$/;
	return validaRegex('cpf', regex);
}

function validaTelefone(){
	let regex = /^\(\d{2}\) 9?\d{4}-\d{4}$/;
	return validaRegex('telefone', regex);
}

function validaSexo(){
	let elemento = document.forms['inter'].sexo;
	let valor = elemento.value;
	let divSexo = document.querySelector(".sexo");
	if(valor == ""){
		divSexo.classList.add("error");
		return false;
	}else{
		divSexo.classList.remove("error");
		return true;
	}
}

function validaIdiomas(){
	let elementosCheck = document.forms['inter'].linguas;
	let divIdiomas = document.querySelector(".linguas");
	let contador = 0;
	for(let i=0 ; i<elementosCheck.length; i++){
		let lingua = elementosCheck[i];
		if(lingua.checked){
			contador++;
		}
	}
	if(contador >= 3){
		divIdiomas.classList.remove("error");
		return true;
	}else{
		divIdiomas.classList.add("error");
		return false;
	}
}

function validaEstado(){
	let resultValidar =  validaSelect('estado');
	apagaOpcoesCidades();
	if(!resultValidar){
		return false;
	}else{
		carregaCidades();
		return true;
	}
}

function carregaCidades(){
	let elEstado = document.forms['inter'].estado;
	let indexOpcaoSelecionada = elEstado.selectedIndex;
	let opcaoSelecionada = elEstado.options[indexOpcaoSelecionada];
	let valorSelecionado = opcaoSelecionada.value;

	//let pegarTudo = elEstado.options[elEstado.selectedIndex].value;
	let elCidade = document.forms['inter'].cidade;
	if(valorSelecionado == 'mg'){
		elCidade.options[elCidade.options.length] = new Option('UBerlandia', 'udia');
		elCidade.options[elCidade.options.length] = new Option('Uberaba', 'ura');
		elCidade.options[elCidade.options.length] = new Option('Belo Horizonte', 'bh');
	}else if(valorSelecionado == 'sp'){
		elCidade.options[elCidade.options.length] = new Option('São Paulo', 'sp');
		elCidade.options[elCidade.options.length] = new Option('Campinas', 'camp');
		elCidade.options[elCidade.options.length] = new Option('Riberão Preto', 'rp');
                elCidade.options[elCidade.options.length] = new Option('Santos', 'san');
	}else if(valorSelecionado == 'go'){
		elCidade.options[elCidade.options.length] = new Option('Morrinhos', 'udia');
		elCidade.options[elCidade.options.length] = new Option('Goiania', 'ura');
		elCidade.options[elCidade.options.length] = new Option('Goiatuba', 'gtba');
		elCidade.options[elCidade.options.length] = new Option('Pontalina', 'pnn');
	}
}

function apagaOpcoesCidades(){
	let elCidade = document.forms['inter'].cidade;
	while(elCidade.options.length > 1){
		elCidade.remove(1);
	}
}

function validaCidade(){
	return validaSelect('cidade');
}

function validaSelect(field){
	let elemento = document.forms['inter'][field];
	let opcaoSelecionada = elemento.selectedIndex;
	if(opcaoSelecionada == 0){
		elemento.classList.add("error")
		return false;
	}else{
		elemento.classList.remove("error")
		return true;
	}
}

function validaRegex(field, regex){
	let elemento = document.forms['inter'][field];
	let valor = elemento.value;
	if(regex.test(valor)){
		elemento.classList.remove("error");
		return true;
	}else{
		elemento.classList.add("error");
		return false;
	}
}
