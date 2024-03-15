import 'package:flutter/material.dart';

// Em Flutter, a necessidade da classe State e do widget StatefulWidget decorre da natureza reativa da arquitetura do framework.
// Aqui estão algumas razões pelas quais esses recursos são necessários:

// 1. Gerenciamento de Estado: Em muitas aplicações, o estado dos widgets precisa ser modificado durante a execução do aplicativo
// em resposta a eventos do usuário, alterações nos dados ou outras condições. O widget StatefulWidget encapsula o estado mutável,
// enquanto a classe State gerencia esse estado, permitindo que os widgets atualizem sua aparência conforme necessário.

// 2. Reconstrução Condicional: O Flutter adota uma abordagem de "reconstrução completa" para atualizações de interface do usuário.
// Isso significa que, quando o estado de um widget muda, ele pode precisar ser reconstruído para refletir as novas informações.
// O widget StatefulWidget junto com a classe State facilita essa reconstrução ao gerenciar quando e como os widgets são reconstruídos.

// 3. Interatividade: Em aplicativos interativos, como formulários, jogos ou qualquer coisa que exija entrada do usuário,
// é crucial poder modificar a interface do usuário em resposta a eventos do usuário. O uso de StatefulWidget e State permite
// que os desenvolvedores criem interfaces de usuário dinâmicas e responsivas.

// 4. Eficiência de Desempenho: Ao separar a parte estática de um widget (definida na classe StatelessWidget) da parte mutável
// (gerenciada pela classe State), o Flutter pode otimizar a renderização, atualizando apenas as partes da interface do usuário
// que realmente mudaram. Isso ajuda a manter um desempenho suave mesmo em aplicativos complexos.

// Portanto, as classes StatefulWidget e State são essenciais no Flutter para lidar com o estado mutável e a atualização da
// interface do usuário de forma eficiente e responsiva, facilitando o desenvolvimento de aplicativos robustos e interativos.

// Definimos uma classe chamada MainUi, que é um StatefulWidget.
// Isso significa que o widget pode ter seu estado alterado durante a vida útil da aplicação.
class MainUi extends StatefulWidget {
  const MainUi({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _MainUiState();
}

// Aqui temos a definição da classe _MainUiState, que estende State<MainUi>.
// Esta é a classe que gerencia o estado do widget de nossa interface.
class _MainUiState extends State<MainUi> {
  @override
  Widget build(BuildContext context) {
    // No método build, um layout é construído usando o widget Padding como wrapper principal,
    // com um preenchimento uniforme de 16 dp em todos os lados.
    // No geral, esse código cria uma interface de usuário simples com campos de texto para entrada de dados,
    // organizados verticalmente em uma coluna, com dois campos adicionais lado a lado em uma linha.
    //https://api.flutter.dev/flutter/widgets/Padding-class.html
    return const Padding(
      padding: EdgeInsets.all(16),
      // Dentro deste padding, há um Column, que organiza seus filhos verticalmente, neste caso os componentes Widget.
      //https://api.flutter.dev/flutter/widgets/Column-class.html
      child: Column(
        children: <Widget>[
          // Dentro da Column, há três TextField, cada um com um decoration diferente
          // para exibir um texto de dica dentro do campo.
          //https://api.flutter.dev/flutter/material/TextField-class.html
          TextField(
            decoration: InputDecoration(hintText: "Nome"),
          ),
          TextField(
            decoration: InputDecoration(hintText: "CPF"),
          ),
          // Além disso, há um Row que contém dois TextField organizados horizontalmente
          // usando Expanded para ocupar o espaço disponível de forma uniforme.
          Row(
            children: <Widget>[
              //Ao utilizar o TextField lembre-se de envolver eles com um container Expanded e
              // https://api.flutter.dev/flutter/widgets/Expanded-class.html
              Expanded(
                child: TextField(
                  decoration: InputDecoration(hintText: "RG"),
                ),
              ),
              // Entre os dois TextField, há um SizedBox com uma largura de 16 pixels para separação.
              SizedBox(width: 16),
              Expanded(
                child: TextField(
                  decoration: InputDecoration(hintText: "Titulo"),
                ),
              )
            ],
          )
        ],
      ),
    );
  }
}
