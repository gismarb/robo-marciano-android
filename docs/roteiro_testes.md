# Roteiro de Testes — Robô Marciano Android

Data: 20/06/2026

---

## 1. Objetivo

Este roteiro descreve os testes manuais e automatizados para validar o funcionamento do app **Robô Marciano Android**.

---

## 2. Testes automatizados

### 2.1 Executar todos os testes unitários

Comando:

```bash
./gradlew test
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```

---

## 3. Testes manuais da tela principal

### CT-001 — Abertura do app

**Passos:**

1. Abrir o app no emulador ou dispositivo.
2. Observar a tela principal.

**Resultado esperado:**

- título exibido;
- imagem do robô exibida;
- seletor de tipo de robô exibido;
- campo de mensagem exibido;
- botão de envio exibido.

---

### CT-002 — Seleção do tipo de robô

**Passos:**

1. Abrir o seletor de tipo de robô.
2. Verificar as opções disponíveis.

**Resultado esperado:**

As opções abaixo devem aparecer:

```text
Robô Básico
Robô Avançado
Robô Premium
```

---

## 4. Testes manuais do Robô Básico

Selecionar:

```text
Robô Básico
```

### CT-003 — Mensagem vazia

**Entrada:**

```text

```

**Resultado esperado:**

```text
Não me incomode
```

---

### CT-004 — Mensagem com espaços

**Entrada:**

```text

```

**Resultado esperado:**

```text
Não me incomode
```

---

### CT-005 — Mensagem com quebra de linha

**Entrada:**

```text


```

**Resultado esperado:**

```text
Não me incomode
```

---

### CT-006 — Pergunta

**Entrada:**

```text
Tudo bem?
```

**Resultado esperado:**

```text
Certamente
```

---

### CT-007 — Grito

**Entrada:**

```text
EU quero testar
```

**Resultado esperado:**

```text
Opa! Calma aí!
```

---

### CT-008 — Palavra “eu” sem grito

**Entrada:**

```text
Eu quero testar
```

**Resultado esperado:**

```text
A responsabilidade é sua
```

---

### CT-009 — Pergunta e grito

**Entrada:**

```text
EU quero testar?
```

**Resultado esperado:**

```text
Relaxa, eu sei o que estou fazendo!
```

---

### CT-010 — Mensagem comum

**Entrada:**

```text
Olá robô
```

**Resultado esperado:**

```text
Tudo bem, como quiser
```

---

## 5. Testes manuais do Robô Avançado

Selecionar:

```text
Robô Avançado
```

### CT-011 — Soma

**Entrada:**

```text
some 2 3
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

### CT-012 — Subtração

**Entrada:**

```text
subtraia 10 4
```

**Resultado esperado:**

```text
Essa eu sei: 6
```

---

### CT-013 — Multiplicação

**Entrada:**

```text
multiplique 3 5
```

**Resultado esperado:**

```text
Essa eu sei: 15
```

---

### CT-014 — Divisão

**Entrada:**

```text
divida 10 2
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

### CT-015 — Divisão por zero

**Entrada:**

```text
divida 10 0
```

**Resultado esperado:**

```text
Erro: não é possível dividir por zero
```

---

### CT-016 — Números com vírgula

**Entrada:**

```text
some 2,5 3,5
```

**Resultado esperado:**

```text
Essa eu sei: 6
```

---

### CT-017 — Herança do comportamento básico

**Entrada:**

```text
Tudo bem?
```

**Resultado esperado:**

```text
Certamente
```

---

## 6. Testes manuais do Robô Premium

Selecionar:

```text
Robô Premium
```

### CT-018 — Comando agir

**Entrada:**

```text
agir
```

**Resultado esperado:**

A resposta deve conter:

```text
É pra já!
```

e uma frase sobre tecnologia.

---

### CT-019 — Frases aleatórias

**Passos:**

1. Enviar o comando `agir`.
2. Voltar para a tela principal.
3. Enviar novamente o comando `agir`.
4. Repetir algumas vezes.

**Resultado esperado:**

A frase após `É pra já!` pode variar entre as opções cadastradas na classe `MarcianoPremium`.

---

### CT-020 — AGIR em maiúsculo

**Entrada:**

```text
AGIR
```

**Resultado esperado:**

```text
Opa! Calma aí!
```

Justificativa: o comando premium é `agir` em minúsculo. `AGIR` é interpretado como grito.

---

### CT-021 — Operação herdada do avançado

**Entrada:**

```text
some 2 3
```

**Resultado esperado:**

```text
Essa eu sei: 5
```

---

## 7. Testes de navegação

### CT-022 — Voltar pelo botão do app

**Passos:**

1. Enviar uma mensagem.
2. Na tela de resposta, clicar em **Voltar**.

**Resultado esperado:**

- app retorna para a tela principal;
- campo de mensagem aparece vazio;
- scroll volta para o topo.

---

### CT-023 — Voltar pelo botão do Android

**Passos:**

1. Enviar uma mensagem.
2. Na tela de resposta, usar o botão voltar do Android.

**Resultado esperado:**

- app retorna para a tela principal;
- campo de mensagem aparece vazio;
- scroll volta para o topo.

---

## 8. Testes visuais

### CT-024 — Identidade visual

**Passos:**

1. Abrir a tela principal.
2. Enviar uma mensagem.
3. Observar a tela de resposta.

**Resultado esperado:**

- imagem vetorial do robô aparece nas duas telas;
- botões possuem fundo azul e texto branco;
- campo de mensagem possui fundo branco e borda azul;
- cartões de mensagem e resposta aparecem com cantos arredondados.

---

## 9. Critério de aceite

O app é considerado aprovado quando:

- o build passa;
- os testes unitários passam;
- a tela principal abre corretamente;
- a tela de resposta abre corretamente;
- as regras do robô são respeitadas;
- o retorno para nova pergunta funciona;
- o campo de mensagem é limpo ao retornar.
