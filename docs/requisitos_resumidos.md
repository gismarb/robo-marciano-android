# Requisitos Resumidos — Robô Marciano Android

Data: 20/06/2026

---

## 1. Objetivo

Desenvolver um aplicativo Android que funcione como interface gráfica para o Robô Marciano, reaproveitando e adaptando a lógica do projeto anterior em Kotlin para terminal.

O aplicativo deve permitir que o usuário envie mensagens ao robô e visualize a resposta em uma tela própria.

---

## 2. Escopo obrigatório

### 2.1 Tela principal

A tela principal deve conter:

- campo para entrada da mensagem;
- botão para envio da mensagem ao robô;
- seleção do tipo de robô.

No projeto, essa tela foi implementada na classe:

```text
MainActivity.kt
```

Layout correspondente:

```text
activity_main.xml
```

---

### 2.2 Tela de resposta

A tela de resposta deve:

- receber a mensagem enviada;
- receber o tipo de robô selecionado;
- processar a mensagem usando a regra de negócio;
- exibir a resposta do robô;
- permitir retorno à tela principal.

No projeto, essa tela foi implementada na classe:

```text
AnswerActivity.kt
```

Layout correspondente:

```text
activity_answer.xml
```

---

### 2.3 Retorno para nova pergunta

Ao retornar da tela de resposta para a tela principal:

- o campo de mensagem deve estar limpo;
- o usuário deve conseguir digitar uma nova mensagem;
- o retorno deve funcionar pelo botão do app e pelo botão voltar do Android.

Essa regra foi implementada no método `onResume()` da `MainActivity`.

---

## 3. Tipos de robô

O aplicativo trabalha com três tipos de robô:

```text
Robô Básico
Robô Avançado
Robô Premium
```

A representação técnica desses tipos está em:

```text
domain/model/TipoRobo.kt
```

---

## 4. Regras do Robô Básico

Classe:

```text
domain/robot/Marciano.kt
```

Regras:

| Situação | Resposta |
|---|---|
| mensagem vazia, espaços ou quebras de linha | Não me incomode |
| pergunta + grito | Relaxa, eu sei o que estou fazendo! |
| grito | Opa! Calma aí! |
| pergunta | Certamente |
| contém a palavra “eu” | A responsabilidade é sua |
| demais mensagens | Tudo bem, como quiser |

---

## 5. Regras do Robô Avançado

Classe:

```text
domain/robot/MarcianoAvancado.kt
```

O Robô Avançado herda as regras do Robô Básico e adiciona operações matemáticas.

Comandos suportados:

| Comando | Exemplo |
|---|---|
| some | `some 2 3` |
| subtraia | `subtraia 10 4` |
| multiplique | `multiplique 3 5` |
| divida | `divida 10 2` |

Tratamento especial:

```text
divida 10 0
```

Resposta:

```text
Erro: não é possível dividir por zero
```

---

## 6. Regras do Robô Premium

Classe:

```text
domain/robot/MarcianoPremium.kt
```

O Robô Premium herda as regras do Robô Avançado e adiciona o comando:

```text
agir
```

A resposta contém:

```text
É pra já!
```

seguido de uma frase aleatória sobre tecnologia.

---

## 7. Requisitos técnicos implementados

- Kotlin como linguagem principal;
- Android Views/XML para construção das telas;
- ViewBinding para acesso aos componentes de tela;
- duas Activities principais;
- pacote `domain` para separar regra de negócio da interface;
- imagem do robô criada como Vector Drawable XML;
- cores e textos centralizados em arquivos de recursos;
- testes unitários com JUnit.

---

## 8. Requisitos atendidos

| Requisito | Status |
|---|---|
| App Android funcional | Atendido |
| Tela principal com entrada de mensagem | Atendido |
| Botão para envio da mensagem | Atendido |
| Tela de resposta | Atendido |
| Exibição da resposta do robô | Atendido |
| Retorno para tela principal | Atendido |
| Campo limpo ao retornar | Atendido |
| Uso de Kotlin | Atendido |
| Adaptação do robô anterior | Atendido |

---

## 9. Itens extras planejados

Os itens abaixo não fazem parte do MVP já concluído, mas podem ser implementados como evolução:

- tela intermediária para operações matemáticas;
- histórico de comandos;
- reenvio de mensagens a partir do histórico;
- melhoria da experiência visual em formato de chat;
- persistência local do histórico.
