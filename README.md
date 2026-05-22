# LogAuto POO - Sistema de Controle de Transporte via Cegonha

Projeto acadêmico em Java com Swing, criado para demonstrar de forma prática os principais pilares da Programação Orientada a Objetos: classes, objetos, encapsulamento, herança, polimorfismo e abstração.

## Tema

Sistema fictício da transportadora **LogAuto**, responsável por controlar o transporte de veículos por caminhão cegonha.

## Estrutura

```text
src/
├── main/
│   └── Main.java
├── model/
│   ├── Veiculo.java
│   ├── Carro.java
│   ├── Moto.java
│   ├── CaminhaoCegonha.java
│   └── Transporte.java
├── service/
│   └── TransporteService.java
└── ui/
    └── TelaPrincipal.java
```

## Onde cada conceito de POO aparece

### Classes e Objetos
- Classes: `Veiculo`, `Carro`, `Moto`, `CaminhaoCegonha`, `Transporte`, `TransporteService`, `TelaPrincipal`.
- Objetos são criados na interface ao cadastrar veículos e no serviço ao montar o transporte.

### Encapsulamento
Todos os atributos principais são `private` e acessados por métodos `get` e `set`.

Exemplo:
```java
private String placa;

public String getPlaca() {
    return placa;
}
```

### Herança
`Carro` e `Moto` herdam da classe abstrata `Veiculo`.

```java
public class Carro extends Veiculo
public class Moto extends Veiculo
```

### Polimorfismo
O método `calcularFrete()` é sobrescrito em `Carro` e `Moto`.

```java
@Override
public double calcularFrete() {
    return 1500.00;
}
```

### Abstração
`Veiculo` é uma classe abstrata. Ela representa o conceito geral de veículo, mas quem é instanciado são tipos específicos como `Carro` e `Moto`.

```java
public abstract class Veiculo
```

## Tutorial rápido para execução no Windows

### 1. Verificar se o Java está instalado

Abra o Prompt de Comando ou PowerShell e execute:

```bash
java -version
```

Depois execute:

```bash
javac -version
```

O ideal é aparecer uma versão do JDK instalada, por exemplo Java 17, 21 ou superior.

Se `javac` não for reconhecido, provavelmente você tem apenas o JRE ou o Java não está configurado no PATH.

### 2. Entrar na pasta do projeto

Exemplo:

```bash
cd C:\Users\SeuUsuario\Desktop\LogAutoPOO
```

### 3. Compilar o projeto

Execute:

```bash
mkdir out
javac -encoding UTF-8 -d out src\model\*.java src\service\*.java src\ui\*.java src\main\*.java
```

### 4. Executar o sistema

Execute:

```bash
java -cp out main.Main
```

A janela Swing do sistema LogAuto deverá abrir.

## Execução por IDE

Também é possível abrir o projeto no IntelliJ IDEA, Eclipse, VS Code ou NetBeans.

O arquivo principal é:

```text
src/main/Main.java
```

Execute a classe `Main`.

## Roteiro de apresentação sugerido

1. Apresentar o tema: LogAuto, transporte de veículos por cegonha.
2. Mostrar a estrutura de pacotes: `model`, `service`, `ui`, `main`.
3. Explicar a classe abstrata `Veiculo` como abstração.
4. Mostrar `Carro` e `Moto` herdando de `Veiculo`.
5. Mostrar os atributos privados e getters/setters como encapsulamento.
6. Mostrar o método `calcularFrete()` sobrescrito como polimorfismo.
7. Executar a interface e cadastrar veículos.
8. Gerar relatório e explicar que a lista de `Veiculo` aceita objetos `Carro` e `Moto`.

## Frase-chave para defesa

> O sistema foi construído com uma arquitetura compacta e didática, usando Java Swing para demonstrar visualmente a criação de objetos, a interação entre classes e os pilares fundamentais da Programação Orientada a Objetos.
