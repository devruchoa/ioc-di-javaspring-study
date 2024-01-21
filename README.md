# IoC (Inversão de Controle) e DI (Injeção de Dependência) com Spring Boot

## O que é IoC?

IoC é um princípio de engenharia de software que transfere o controle de objetos ou partes de um programa para um container ou framework. IoC permite que o framework assuma o controle do fluxo do programa e faça chamadas ao nosso código.

## Por que usar IoC?

1. Reduzir o acoplamento entre classes.
2. Facilitar os testes (Podemos isolar um componente e "simular" as dependências).
3. Facilitar a troca de implementações, ou seja, facilitar a manutenção.
4. Aumentar a modularidade do código.

## Como IoC é implementado?

IoC é implementado através de diversos mecanismos diferentes, como o padrão de projeto Strategy, o padrão Service Locator, o padrão Factory e a Injeção de Dependência (DI). Neste artigo, vamos focar em DI.

## O que é DI?

DI é um padrão de projeto que podemos usar para implementar IoC. Conectamos objetos a objetos, ou melhor, injetamos objetos em outros objetos, mas isso não é feito manualmente (pelos próprios objetos), e sim por um container que gerencia as dependências.

### Exemplo de Dependência de Objetos

Tradicionalmente, quando um objeto precisa de outro objeto, ele mesmo cria uma instância desse objeto. Por exemplo, se temos uma classe `A` que precisa de uma instância de `B`, a classe `A` cria uma instância de `B` dentro dela mesma.

```java
public class A {
    private B b = new B();
}
```

Este é um exemplo claro e objetivo de acoplamento forte, o que traz diversos problemas, como: tornar o código menos flexível e mais difícil de manter e testar. A não pode funcionar sem B, e qualquer alteração em B pode afetar A.

### Exemplo de Injeção de Dependência

Na DI, a classe `A` não cria uma instância de `B`, mas recebe uma instância de `B` de fora. A classe `A` não sabe como criar uma instância de `B`, ela apenas recebe uma instância de `B` de fora.

```java
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }
}
```

## O Container IoC do Spring

O Spring é um framework que implementa IoC e DI. Um Container IoC é uma característica comum de frameworks que implementam IoC. O Container Spring é responsável por instanciar, configurar e montar objetos conhecidos como Beans, além de gerenciar seu ciclo de vida.

## Formas de Injeção de Dependência

Existem três formas de injeção de dependência no Spring:

1. Injeção de dependência via construtor.
2. Injeção de dependência via método setter.
3. Injeção de dependência via campo.

Os três possuem exemplos no código. Porém, quero ressaltar que a forma mais recomendada pela documentação do Spring é a injeção via construtor para dependências obrigatórias, baseada em setter para dependências opcionais e baseada em campo para dependências opcionais. A injeção por campo é de longe a mais limpa e simples, mas carrega consigo problemas:

1. A injeção por campo utiliza reflexão, o que pode ser um problema de performance, em relação às outras opções com setter e construtor. Reflexão é quando o código é capaz de inspecionar e modificar o comportamento de um programa em tempo de execução. E é um problema por quebrar o encapsulamento, ter implicações de segurança e tornar o código mais complexo para depurar.
2. Por ser extremamente simples, pode nos enganar e nos levar a criar classes que fazem mais de uma coisa, o que quebraria o princípio da responsabilidade única. Quando fazemos por construtor, temos que criar explicitamente, o que nos leva a observar mais facilmente este comportamento indesejado.