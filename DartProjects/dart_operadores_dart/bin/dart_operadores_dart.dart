void main() {
  // Operadores aritméticos
  int a = 10;
  int b = 5;
  int soma = a + b;
  int subtracao = a - b;
  double divisao = a / b;
  int multiplicacao = a * b;
  int resto = a % b;

  print('Operadores Aritméticos:');
  print('Soma: $soma');
  print('Subtração: $subtracao');
  print('Divisão: $divisao');
  print('Multiplicação: $multiplicacao');
  print('Resto da divisão: $resto\n');

  // Operadores relacionais
  bool maiorQue = a > b;
  bool menorQue = a < b;
  bool igual = a == b;
  bool diferente = a != b;

  print('Operadores Relacionais:');
  print('Maior que: $maiorQue');
  print('Menor que: $menorQue');
  print('Igual: $igual');
  print('Diferente: $diferente\n');

  // Operadores lógicos
  bool verdadeiro = true;
  bool falso = false;
  bool and = verdadeiro && falso;
  bool or = verdadeiro || falso;
  bool not = !verdadeiro;

  print('Operadores Lógicos:');
  print('AND: $and');
  print('OR: $or');
  print('NOT: $not\n');

  // Operadores condicionais
  int numero = 7;
  String resultado = (numero % 2 == 0) ? 'Par' : 'Ímpar';

  print('Operadores Condicionais:');
  print('O número $numero é $resultado\n');

  // Operadores de atribuição
  int x = 10;
  x += 5; // Equivalente a x = x + 5
  int y = 20;
  y -= 3; // Equivalente a y = y - 3
  int z = 5;
  z *= 2; // Equivalente a z = z * 2

  print('Operadores de Atribuição:');
  print('x: $x');
  print('y: $y');
  print('z: $z\n');

  // Operador de nulabilidade (?)
  String? nullableString;
  String nonNullableString = 'Não nulo';

  print('Operador de Nulabilidade:');
  print('Nullable String: $nullableString');
  print('Non-Nullable String: $nonNullableString');
}
