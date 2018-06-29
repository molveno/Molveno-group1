

function alertFoo() {

    alert("You clicked the button");

}

function birdChange() {
    document.getElementById("bird").innerHTML = "Raaf";
}

function bar() {
    console.log("Bar invoked");

    var counter = 3;

    counter++;

    console.log(counter);

    counter = "Three";

    console.log(counter);

    var cars = ["Saab", "Volvo", "BMW"];

    console.log(cars);

    cars = 15;

    return counter;
}