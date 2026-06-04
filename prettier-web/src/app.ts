interface User {
  name: string;
  age: number;
  email?: string;
}

const users: User[] = [
  { name: "Alice", age: 30 },
  { name: "Bob", age: 25, email: "bob@example.com" },
];

function describe(u: User): string {
  return `${u.name} (${u.age})${u.email ? ` <${u.email}>` : ""}`;
}

users.forEach((u) => {
  console.log(describe(u));
});
