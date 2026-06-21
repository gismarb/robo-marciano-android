# Requisitos Resumidos — Robô Marciano Android

## 1. Identificação do projeto

**Projeto:** Robô Marciano Android  
**Repositório:** `robo-marciano-android`  
**Projeto base anterior:** [Robô Marciano Kotlin](https://github.com/gismarb/robo-marciano-kotlin)  
**Tipo de aplicação:** Aplicativo Android  
**Linguagem principal:** Kotlin  
**Interface:** Android Views/XML  
**Objetivo:** criar uma interface mobile para interação com o Robô Marciano, adaptando a regra de negócio do projeto Kotlin original para uma aplicação Android.

---

## 2. Escopo geral

O aplicativo deve permitir que o usuário selecione um tipo de robô, informe uma mensagem e visualize a resposta calculada pela regra de negócio do Robô Marciano.

A aplicação Android substitui a interação via terminal do projeto Kotlin original por uma experiência visual com telas, botões, campos de entrada e navegação entre Activities.

---

## 3. Requisitos funcionais

### RF001 — Tela principal

O sistema deve possuir uma tela principal para entrada da mensagem do usuário.

#### RF001.1 — Exibição do título

A tela principal deve exibir o título do aplicativo.

#### RF001.2 — Exibição da imagem do robô

A tela principal deve exibir uma representação visual do Robô Marciano.

#### RF001.3 — Campo de mensagem

A tela principal deve conter um campo para digitação da mensagem do usuário.

#### RF001.4 — Botão de envio

A tela principal deve conter um botão para enviar a mensagem ao robô.

---

### RF002 — Seleção do tipo de robô

O sistema deve permitir que o usuário selecione o tipo de robô que responderá à mensagem.

#### RF002.1 — Robô Básico

O sistema deve permitir a seleção do Robô Básico.

#### RF002.2 — Robô Avançado

O sistema deve permitir a seleção do Robô Avançado.

#### RF002.3 — Robô Premium

O sistema deve permitir a seleção do Robô Premium.

---

### RF003 — Tela de resposta

O sistema deve possuir uma tela de resposta para apresentar o resultado da interação com o robô.

#### RF003.1 — Exibição do tipo de robô

A tela de resposta deve exibir o tipo de robô selecionado.

#### RF003.2 — Exibição da mensagem enviada

A tela de resposta deve exibir a mensagem informada pelo usuário.

#### RF003.3 — Exibição da resposta

A tela de resposta deve exibir a resposta calculada pela regra de negócio do robô.

#### RF003.4 — Botão de retorno

A tela de resposta deve possuir um botão para retornar à tela principal.

---

### RF004 — Retorno para nova interação

O sistema deve permitir que o usuário volte para a tela principal e envie uma nova mensagem.

#### RF004.1 — Retorno pelo botão do app

O usuário deve conseguir retornar usando o botão **Voltar** da tela de resposta.

#### RF004.2 — Retorno pelo botão do Android

O usuário deve conseguir retornar usando o botão voltar do próprio Android.

#### RF004.3 — Limpeza do campo de mensagem

Ao retornar para a tela principal, o campo de mensagem deve estar limpo.

#### RF004.4 — Reposicionamento da tela

Ao retornar para a tela principal, o conteúdo deve voltar ao topo da tela.

---

### RF005 — Regras do Robô Básico

O sistema deve implementar as regras de resposta do Robô Básico.

#### RF005.1 — Mensagem vazia

Quando a mensagem estiver vazia ou possuir apenas espaços/quebras de linha, o robô deve responder:

```text
Não me incomode
```

#### RF005.2 — Pergunta

Quando a mensagem for uma pergunta, o robô deve responder:

```text
Certamente
```

#### RF005.3 — Grito

Quando a mensagem possuir palavra em maiúsculas caracterizando grito, o robô deve responder:

```text
Opa! Calma aí!
```

#### RF005.4 — Pergunta e grito

Quando a mensagem for simultaneamente pergunta e grito, o robô deve responder:

```text
Relaxa, eu sei o que estou fazendo!
```

#### RF005.5 — Palavra “eu”

Quando a mensagem contiver a palavra “eu” e não cair em uma regra de maior precedência, o robô deve responder:

```text
A responsabilidade é sua
```

#### RF005.6 — Mensagem comum

Quando a mensagem não se enquadrar nas regras anteriores, o robô deve responder:

```text
Tudo bem, como quiser
```

---

### RF006 — Regras do Robô Avançado

O sistema deve implementar o Robô Avançado como uma evolução do Robô Básico.

#### RF006.1 — Herança das regras básicas

O Robô Avançado deve manter as regras do Robô Básico.

#### RF006.2 — Soma

O Robô Avançado deve responder ao comando:

```text
some número1 número2
```

#### RF006.3 — Subtração

O Robô Avançado deve responder ao comando:

```text
subtraia número1 número2
```

#### RF006.4 — Multiplicação

O Robô Avançado deve responder ao comando:

```text
multiplique número1 número2
```

#### RF006.5 — Divisão

O Robô Avançado deve responder ao comando:

```text
divida número1 número2
```

#### RF006.6 — Divisão por zero

Quando o segundo número da divisão for zero, o robô deve responder:

```text
Erro: não é possível dividir por zero
```

#### RF006.7 — Números com vírgula

O Robô Avançado deve aceitar números decimais informados com vírgula.

---

### RF007 — Regras do Robô Premium

O sistema deve implementar o Robô Premium como uma evolução do Robô Avançado.

#### RF007.1 — Herança das regras avançadas

O Robô Premium deve manter as regras do Robô Avançado.

#### RF007.2 — Comando agir

O Robô Premium deve responder ao comando:

```text
agir
```

#### RF007.3 — Frase aleatória

Após o comando `agir`, o Robô Premium deve exibir uma frase aleatória sobre tecnologia.

#### RF007.4 — Comando agir em maiúsculas

O comando `AGIR`, em maiúsculas, deve ser tratado como grito, não como comando premium.

---

### RF008 — Testes unitários

O sistema deve possuir testes unitários para validar a regra de negócio do robô.

#### RF008.1 — Testes do Robô Básico

Devem existir testes para validar as regras básicas.

#### RF008.2 — Testes do Robô Avançado

Devem existir testes para validar as operações matemáticas e a herança das regras básicas.

#### RF008.3 — Testes do Robô Premium

Devem existir testes para validar o comando `agir`, as frases aleatórias e a herança das regras avançadas.

---

## 4. Requisitos não funcionais

### RNF001 — Linguagem de programação

O aplicativo deve ser desenvolvido em Kotlin.

### RNF002 — Ambiente de desenvolvimento

O projeto deve ser desenvolvido e executado no Android Studio.

### RNF003 — Interface Android

A interface deve ser construída com Android Views/XML.

### RNF004 — ViewBinding

O projeto deve utilizar ViewBinding para acessar os componentes das telas.

### RNF005 — Separação de responsabilidades

A regra de negócio do robô deve ficar separada da camada de interface Android.

### RNF006 — Organização por pacotes

O código deve ser organizado em pacotes, separando interface, modelo, regra de negócio e utilitários.

### RNF007 — Recursos Android

Textos visíveis de interface devem estar centralizados em `strings.xml`.

### RNF008 — Cores

Cores da interface devem estar centralizadas em `colors.xml`.

### RNF009 — Identidade visual

O aplicativo deve possuir uma identidade visual simples, com imagem vetorial do robô e botões personalizados.

### RNF010 — Versionamento

O projeto deve ser versionado com Git e publicado no GitHub.

### RNF011 — Documentação

O projeto deve possuir README e documentação complementar na pasta `docs`.

---

## 5. Regras de negócio

### RN001 — Precedência das respostas

As regras do Robô Básico devem respeitar a seguinte precedência:

```text
1. mensagem vazia
2. pergunta + grito
3. grito
4. pergunta
5. palavra “eu”
6. resposta padrão
```

### RN002 — Mensagem vazia

A mensagem vazia deve ser tratada pela regra de negócio, e não bloqueada pela interface.

### RN003 — Independência da camada de domínio

As respostas do robô devem permanecer na camada de domínio, sem dependência direta de `Context` ou `strings.xml`.

### RN004 — Comandos matemáticos

Os comandos matemáticos devem possuir exatamente três partes:

```text
operação número1 número2
```

### RN005 — Formatação de resultados inteiros

Quando o resultado matemático for inteiro, ele deve ser exibido sem casas decimais.

### RN006 — Comando premium

O comando premium deve ser reconhecido apenas quando a mensagem for exatamente:

```text
agir
```

---

## 6. Itens extras planejados

Os itens abaixo podem ser implementados como evolução do projeto:

- histórico de comandos;
- reenvio de mensagens a partir do histórico;
- tela específica para operações matemáticas;
- persistência local do histórico;
- melhoria da experiência visual em formato de conversa.
