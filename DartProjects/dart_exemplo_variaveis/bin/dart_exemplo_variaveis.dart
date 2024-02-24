void main() {
  // Declaração de variáveis numéricas
  int idade = 25; // idade é do tipo inteiro
  double altura = 1.75; // altura é do tipo ponto flutuante

  // Declaração de variáveis de texto
  String nome = 'João'; // nome é do tipo String (sequência de caracteres)

  // Declaração de variáveis lógicas
  bool estudante = true; // estudante é do tipo booleano

  // Impressão dos valores das variáveis
  print('Nome: $nome');
  print('Idade: $idade anos');
  print('Altura: $altura metros');
  print('É estudante? $estudante');

  // Exemplo de reatribuição de valor a uma variável
  idade = 26;
  print('Nova idade: $idade anos');

  // Exemplo de variável late, que permite a inicialização tardia
  late String descricao;
  descricao = "Esta é uma descrição tardia";

  // Exemplo de variável const, que deve ser inicializada na compilação
  const int numeroConstante = 42;

  // Exemplo de variável final, que é atribuída apenas uma vez e não pode ser modificada
  final double pi = 3.14;

  // Impressão das variáveis
  print("Nome: $nome"); // Pode ser nulo, pois é nullable
  print("Descrição: $descricao");
  print("Número Constante: $numeroConstante");
  print("Valor de Pi: $pi");

  // Declaração de variáveis que podem ser nulas
  String? endereco; // endereco pode ser nulo
  int? numero; // numero pode ser nulo

  // Uso do operador ?? para fornecer um valor padrão se a variável for nula
  endereco = endereco ?? 'Rua das Flores';
  numero = numero ?? 175;

  // Impressão dos valores das variáveis
  print('Endereço: $endereco');
  print('Número: $numero');
}
