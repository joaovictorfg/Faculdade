function e1(){
  let click1 = document.eventos.botao;
  alert ("Parabens!");
  }

let click2 = document.eventos.botao;
click2.addEventListener("click", e2,true);
function e2() {
    for (var i = 0; i < 10; i++) {
       alert ("Parabens!!!!!!");
    }
}
