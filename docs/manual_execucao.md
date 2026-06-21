# Manual de Execução — Robô Marciano Android

## 1. Objetivo

Este documento descreve como abrir, compilar, testar e executar o projeto **Robô Marciano Android**.

O projeto é uma adaptação mobile do [Robô Marciano Kotlin](https://github.com/gismarb/robo-marciano-kotlin), originalmente desenvolvido para execução em terminal.

---

## 2. Pré-requisitos

Para executar o projeto, é necessário possuir:

- Android Studio instalado;
- Android SDK configurado;
- JDK utilizado pelo Android Studio;
- emulador Android configurado ou dispositivo físico;
- Git instalado;
- acesso ao terminal.

---

## 3. Clonando o repositório

Para obter o projeto, execute:

```bash
git clone https://github.com/gismarb/robo-marciano-android.git
```

Entre na pasta do projeto:

```bash
cd robo-marciano-android
```

---

## 4. Abrindo no Android Studio

1. Abra o Android Studio.
2. Selecione **Open**.
3. Escolha a pasta `robo-marciano-android`.
4. Aguarde o **Gradle Sync**.
5. Confirme se o módulo `app` foi carregado corretamente.

---

## 5. Compilando pelo terminal

Na raiz do projeto, execute:

```bash
./gradlew build
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```

---

## 6. Executando os testes

Para executar os testes unitários:

```bash
./gradlew test
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```

Os testes ficam em:

```text
app/src/test/java/br/edu/ifmg/roboandroid/domain/robot
```

Arquivos principais:

```text
MarcianoTest.kt
MarcianoAvancadoTest.kt
MarcianoPremiumTest.kt
```

---

## 7. Executando o app no emulador

1. Abra o Android Studio.
2. Selecione um emulador Android.
3. Clique em **Run**.
4. Aguarde a instalação do app.
5. Verifique se a tela principal foi aberta.

---

## 8. Executando o app em dispositivo físico

1. Ative o modo desenvolvedor no Android.
2. Ative a depuração USB.
3. Conecte o dispositivo ao computador.
4. Autorize a depuração USB no aparelho.
5. Selecione o dispositivo no Android Studio.
6. Clique em **Run**.

---

## 9. Estrutura do projeto

### 9.1 Código principal

```text
app/src/main/java/br/edu/ifmg/roboandroid
├── MainActivity.kt
├── AnswerActivity.kt
└── domain
```

### 9.2 Regra de negócio

```text
domain
├── model
│   └── TipoRobo.kt
├── robot
│   ├── Marciano.kt
│   ├── MarcianoAvancado.kt
│   ├── MarcianoPremium.kt
│   ├── RoboFactory.kt
│   └── RoboRespostas.kt
└── util
    └── UtilTexto.kt
```

### 9.3 Layouts

```text
app/src/main/res/layout
├── activity_main.xml
└── activity_answer.xml
```

### 9.4 Recursos visuais

```text
app/src/main/res/drawable
├── bg_button_primary.xml
├── bg_input_message.xml
├── bg_response_card.xml
└── ic_robo_marciano.xml
```

### 9.5 Recursos de texto e cor

```text
app/src/main/res/values
├── colors.xml
├── strings.xml
└── themes.xml
```

---

## 10. Fluxo de uso

### 10.1 Tela principal

Na tela principal, o usuário deve:

1. selecionar o tipo de robô;
2. digitar uma mensagem;
3. clicar em **Enviar mensagem**.

Tipos disponíveis:

```text
Robô Básico
Robô Avançado
Robô Premium
```

### 10.2 Tela de resposta

Na tela de resposta, o aplicativo apresenta:

- tipo de robô selecionado;
- mensagem enviada;
- resposta do robô;
- botão para voltar.

### 10.3 Nova interação

Ao voltar para a tela principal:

- o campo de mensagem é limpo;
- o scroll retorna ao topo;
- o usuário pode enviar nova mensagem.

---

## 11. Exemplos de uso

### 11.1 Robô Básico

Selecione:

```text
Robô Básico
```

Exemplos:

```text
Tudo bem?
EU quero testar
Eu quero testar
EU quero testar?
Olá robô
```

### 11.2 Robô Avançado

Selecione:

```text
Robô Avançado
```

Exemplos:

```text
some 2 3
subtraia 10 4
multiplique 3 5
divida 10 2
divida 10 0
some 2,5 3,5
```

### 11.3 Robô Premium

Selecione:

```text
Robô Premium
```

Exemplo:

```text
agir
```

Resultado esperado:

```text
É pra já!

[frase aleatória sobre tecnologia]
```

---

## 12. Comandos Git utilizados no fluxo do projeto

Verificar status:

```bash
git status
```

Adicionar arquivos:

```bash
git add .
```

Criar commit:

```bash
git commit -m "mensagem do commit"
```

Enviar para o GitHub:

```bash
git push
```

Ver histórico:

```bash
git log --oneline
```

---

## 13. Observações técnicas

### 13.1 Uso de duas Activities

O app utiliza:

- `MainActivity`, para entrada de dados;
- `AnswerActivity`, para exibição da resposta.

### 13.2 ViewBinding

O ViewBinding foi habilitado para evitar acesso manual aos componentes por `findViewById`.

### 13.3 Regra de negócio separada

As regras do robô estão no pacote `domain`, e não dentro das Activities.

### 13.4 Mensagem vazia

A mensagem vazia não é bloqueada por `Toast`. Ela é enviada para a regra de negócio e o robô responde:

```text
Não me incomode
```

### 13.5 Imagem do robô

A imagem do robô foi criada como `Vector Drawable`, substituindo a ideia do robô em ASCII do projeto Kotlin original.

---

## 14. Problemas comuns

### 14.1 Erro de SDK

Se ocorrer erro relacionado ao SDK, verifique o arquivo:

```text
app/build.gradle.kts
```

E confira se o SDK indicado está instalado no Android Studio.

### 14.2 Binding não encontrado

Se a IDE indicar erro em classes como `ActivityMainBinding` ou `ActivityAnswerBinding`, execute:

```text
File > Sync Project with Gradle Files
Build > Clean Project
Build > Rebuild Project
```

### 14.3 App fecha ao abrir

Abra o **Logcat** e procure por:

```text
FATAL EXCEPTION
```

Durante o desenvolvimento, um erro possível foi manter `backgroundTint` junto com `background` customizado em componentes de layout.

---

## 15. Critério de execução correta

O projeto está funcionando corretamente quando:

- `./gradlew test` passa;
- `./gradlew build` passa;
- o app abre no emulador ou dispositivo;
- a tela principal permite envio de mensagens;
- a tela de resposta exibe o retorno correto;
- o botão voltar retorna para a tela principal;
- o campo de mensagem fica limpo ao retornar.
