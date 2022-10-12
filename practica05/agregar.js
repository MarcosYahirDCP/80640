var toDo = document.getElementById("todo").value

function leer() {
    return document.getElementById("todo").value
}
function agregar() {
    nodo = document.createElement("li")
    //texto = document.createTextNode("Hola mundo")
    texto=document.createTextNode(leer())
    console.log(texto)
    nodo.appendChild(texto)
    document.getElementById("lista").appendChild(nodo)
}

function buscar() {
    let listaTodo = document.getElementsByTagName("li")
    var ban=false
    var arr = [].slice.call(listaTodo)
    arr.forEach(element => {
        if(leer() == element.textContent){
            ban=true
        }
    });
    if (ban) {
        console.log(leer()+ " Existe")
    }else{
        console.log(leer()+" No Existe")
    }
}