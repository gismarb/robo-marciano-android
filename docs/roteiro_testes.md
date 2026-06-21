# Roteiro de Testes — Robô Marciano Android

## 1. Objetivo

Este documento apresenta o roteiro de testes do aplicativo **Robô Marciano Android**.

Os testes validam:

- abertura do app;
- navegação entre telas;
- seleção do tipo de robô;
- regras do Robô Básico;
- regras do Robô Avançado;
- regras do Robô Premium;
- retorno para nova interação;
- identidade visual;
- testes automatizados.

---

## 2. Testes automatizados

### Teste 01 — Executar testes unitários

**Objetivo:** validar as regras de negócio por meio dos testes automatizados.

**Comando:**

```bash
./gradlew test
```

**Resultado esperado:**

```text
BUILD SUCCESSFUL
```

---

### Teste 02 — Executar build completo

**Objetivo:** validar a compilação geral do projeto.

**Comando:**

```bash
./gradlew build
```

**Resultado esperado:**

```text
BUILD SUCCESSFUL
```

---

## 3. Testes da tela principal

### Teste 03 — Abertura do aplicativo

**Passos:**

1. Executar o app no Android Studio.
2. Aguardar a abertura da tela principal.

**Resultado esperado:**

A tela principal deve apresentar:

- título;
- imagem do robô;
- seletor de tipo de robô;
- campo de mensagem;
- botão de envio.

---

### Teste 04 — Seleção dos tipos de robô

**Passos:**

1. Abrir o seletor de tipo de robô.
2. Verificar as opções disponíveis.

**Resultado esperado:**

As opções devem ser:

```text
Robô Básico
Robô Avançado
Robô Premium
```

---

## 4. Testes do Robô Básico

Selecionar:

```text
Robô Básico
```

---

### Teste 05 — Mensagem vazia

**Entrada:**

```text

```

**Resultado esperado:**

```text
Não me incomode
```

---

### Teste 06 — Mensagem com espaços

**Entrada:**

```text
     
```

**Resultado esperado:**

```text
Não me incomode
```

---

### Teste 07 — Mensagem com quebra de linha

**Entrada:**

```text


```

**Resultado esperado:**

```text
Não me incomode
```

---

### Teste 08 — Pergunta simples

**Entrada:**

```text
Tudo bem?
```

**Resultado esperado:**

```text
Certamente
```

---

### Teste 09 — Grito

**Entrada:**

```text
EU quero testar
```

**Resultado esperado:**

```text
Opa! Calma aí!
```

---

### Teste 10 — Palavra “eu” sem grito

**Entrada:**

```text
Eu quero testar
```

**Resultado esperado:**

```text
A responsabilidade é sua
```

---

### Teste 11 — Pergunta com grito

**Entrada:**

```text
EU quero testar?
```

**Resultado esperado:**

```text
Relaxa, eu sei o que estou fazendo!
```

---

### Teste 12 — Mensagem comum

**Entrada:**

```text
Olá robô
```

**Resultado esperado:**

```text
Tudo bem, como quiser
```

---

## 5. Testes do Robô Avançado

Selecionar:

```text
Robô Avançado
```

---

### Teste 13 — Soma

**Entrada:**

```text
some 2 3
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

### Teste 14 — Subtração

**Entrada:**

```text
subtraia 10 4
```

**Resultado esperado:**

```text
Essa eu sei: 6
```

---

### Teste 15 — Multiplicação

**Entrada:**

```text
multiplique 3 5
```

**Resultado esperado:**

```text
Essa eu sei: 15
```

---

### Teste 16 — Divisão

**Entrada:**

```text
divida 10 2
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

### Teste 17 — Divisão por zero

**Entrada:**

```text
divida 10 0
```

**Resultado esperado:**

```text
Erro: não é possível dividir por zero
```

---

### Teste 18 — Soma com vírgula decimal

**Entrada:**

```text
some 2,5 3,5
```

**Resultado esperado:**

```text
Essa eu sei: 6
```

---

### Teste 19 — Herança do comportamento básico

**Entrada:**

```text
Tudo bem?
```

**Resultado esperado:**

```text
Certamente
```

---

## 6. Testes do Robô Premium

Selecionar:

```text
Robô Premium
```

---

### Teste 20 — Comando agir

**Entrada:**

```text
agir
```

**Resultado esperado:**

A resposta deve conter:

```text
É pra já!
```

seguido de uma frase sobre tecnologia.

---

### Teste 21 — Variação de frases aleatórias

**Passos:**

1. Enviar `agir`.
2. Voltar para a tela principal.
3. Enviar `agir` novamente.
4. Repetir algumas vezes.

**Resultado esperado:**

A frase exibida após `É pra já!` pode variar entre as frases cadastradas.

---

### Teste 22 — AGIR em maiúsculas

**Entrada:**

```text
AGIR
```

**Resultado esperado:**

```text
Opa! Calma aí!
```

---

### Teste 23 — Operação matemática herdada

**Entrada:**

```text
some 2 3
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

### Teste 24 — Pergunta herdada do Robô Básico

**Entrada:**

```text
Tudo bem?
```

**Resultado esperado:**

```text
Certamente
```

---

## 7. Testes de navegação

### Teste 25 — Retorno pelo botão do app

**Passos:**

1. Enviar uma mensagem.
2. Na tela de resposta, clicar em **Voltar**.

**Resultado esperado:**

- o app retorna para a tela principal;
- o campo de mensagem aparece vazio;
- a tela volta ao topo.

---

### Teste 26 — Retorno pelo botão do Android

**Passos:**

1. Enviar uma mensagem.
2. Na tela de resposta, usar o botão voltar do Android.

**Resultado esperado:**

- o app retorna para a tela principal;
- o campo de mensagem aparece vazio;
- a tela volta ao topo.

---

## 8. Testes visuais

### Teste 27 — Imagem do robô

**Passos:**

1. Abrir a tela principal.
2. Enviar uma mensagem.
3. Observar a tela de resposta.

**Resultado esperado:**

A imagem vetorial do robô deve aparecer nas duas telas.

---

### Teste 28 — Botões

**Passos:**

1. Observar o botão **Enviar mensagem**.
2. Enviar uma mensagem.
3. Observar o botão **Voltar**.

**Resultado esperado:**

Os botões devem aparecer com fundo azul, texto branco e cantos arredondados.

---

### Teste 29 — Campo de mensagem

**Passos:**

1. Observar o campo de mensagem na tela principal.

**Resultado esperado:**

O campo deve possuir fundo branco, borda azul e área suficiente para digitação.

---

### Teste 30 — Cartões da tela de resposta

**Passos:**

1. Enviar uma mensagem.
2. Observar a mensagem enviada.
3. Observar a resposta do robô.

**Resultado esperado:**

A mensagem e a resposta devem aparecer em áreas separadas com aparência de cartão.

---

## 9. Critério de aceite

O aplicativo é considerado aprovado quando:

- o build passa;
- os testes unitários passam;
- a tela principal abre corretamente;
- a tela de resposta exibe a mensagem e a resposta;
- as regras de negócio são respeitadas;
- o retorno para nova interação funciona;
- o campo de mensagem é limpo ao retornar;
- a identidade visual permanece consistente.
