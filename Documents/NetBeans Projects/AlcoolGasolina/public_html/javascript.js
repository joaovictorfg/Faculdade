function calcular() {
    let n1 = parseFloat(document.querySelector("#ValorGasolina").value);
    let n2 = parseFloat(document.getElementById("ValorAlcool").value);
    let result = n2/n1;
  
    document.getElementById("resultado").innerHTML = result.toFixed(3);
    if (result > 0.7) {
      document.getElementById("Melhor").innerHTML = "Abastasteça com Gasolina";
    }else {
      document.getElementById("Melhor").innerHTML = "Abastasteça com Alcool";
    }
}
