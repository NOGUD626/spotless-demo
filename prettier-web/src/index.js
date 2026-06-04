function greet(name) {
  return "Hello, " + name + "!";
}

const users = ["Alice", "Bob", "Charlie"];
users.forEach(function (u) {
  console.log(greet(u));
});
