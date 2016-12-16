function atividade15(){
	let nomeUsuario = prompt("Digite seu nome:");
	let boasVindas = 'Error 404! ';
	if(nomeUsuario != ''){
		document.querySelector(".resultado").innerHTML =  boasVindas+nomeUsuario;
	}else{
		document.querySelector(".resultado").innerHTML =  boasVindas+"Forasteiro!";
	}
}

function atividade16(){
	let palavra = prompt("Digite uma palavra:");
	if(palavra != ''){
		for(i=0;i<palavra.length; i++){
			let pos = i+1;
			alert("Posição: "+pos+" Letra: "+palavra[i]);
		}
	}
}

function atividade17(){
        let camp = "Palmeiras Campeão";
        alert(camp);
	document.querySelector(".image").src = './palmeiras.png';
       
}


function atividade18(){
	let num1 = parseInt(prompt("Digite o numero 1:"));
	let num2 = parseInt(prompt("Digite o numero 2:"));
	let resultado = document.querySelector('.resultado');
	resultado.innerHTML = "<table><thead><th>Operação</th><th>Valor</th></thead><tbody></tbody>";

	let tabela = document.querySelector('tbody');
	tabela.innerHTML += "<tr><td>"+num1+"+"+num2+"</td><td>"+(num1+num2)+"</td></tr>";
	tabela.innerHTML += "<tr><td>"+num1+"-"+num2+"</td><td>"+(num1-num2)+"</td></tr>";
	tabela.innerHTML += "<tr><td>"+num1+"*"+num2+"</td><td>"+(num1*num2)+"</td></tr>";
	tabela.innerHTML += "<tr><td>"+num1+"%"+num2+"</td><td>"+(num1%num2)+"</td></tr>";
}

function atividade20(){
	let data = prompt("Digite a data no formato xx/xx/xxxx ou xx-xx-xxxx");
	let mes = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
	let dataSplit = data.split('/');
	let mesExtenso = mes[(dataSplit[1]-1)];
	alert(dataSplit[0]+" de "+mesExtenso+" de "+dataSplit[2]);

	switch(parseInt(dataSplit[1])){
		case 1:
			alert(dataSplit[0]+" de Janeiro de "+dataSplit[2]);
			break;
		case 2:
			alert(dataSplit[0]+" de Fevereiro de "+dataSplit[2]);
			break;
		case 3:
			alert(dataSplit[0]+" de Março de "+dataSplit[2]);
			break;
		case 4:
			alert(dataSplit[0]+" de Abril de "+dataSplit[2]);
			break;
	}
}

function atividade22(){
	let str = "maçã.laranja-morango,limão,lima";
	str = str.replace('.',',');
	str = str.replace('-',',');
	str = str.replace('-,', ',');
	alert(str);
}
