# Manual de Execução — Robô Marciano Android

Data: 20/06/2026

---

## 1. Objetivo do documento

Este manual descreve como abrir, compilar, testar e executar o projeto **Robô Marciano Android** no Android Studio.

---

## 2. Pré-requisitos

Para executar o projeto, recomenda-se ter:

- Android Studio instalado;
- JDK configurado pelo próprio Android Studio;
- Gradle Wrapper do projeto;
- Android SDK instalado;
- emulador Android configurado ou dispositivo físico conectado;
- Git instalado.

---

## 3. Estrutura esperada do projeto

A raiz do projeto deve conter arquivos como:

```text
app/
gradle/
build.gradle.kts
settings.gradle.kts
gradlew
gradlew.bat
README.md
docs/
```

A pasta principal do app é:

```text
app/
```

---

## 4. Abrir o projeto no Android Studio

1. Abrir o Android Studio.
2. Selecionar **Open**.
3. Escolher a pasta raiz do projeto:

```text
robo-marciano-android
```

4. Aguardar o **Gradle Sync**.
5. Verificar se o módulo `app` foi carregado corretamente.

---

## 5. Compilar o projeto

No terminal, dentro da raiz do projeto, executar:

```bash
./gradlew build
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```

---

## 6. Executar testes unitários

Para executar os testes da regra de negócio:

```bash
./gradlew test
```

Resultado esperado:

```text
BUILD SUCCESSFUL
```

Os testes estão localizados em:

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

## 7. Executar o app no emulador

1. Abrir o Android Studio.
2. Selecionar um emulador Android.
3. Clicar em **Run**.
4. Aguardar a instalação do app.
5. Verificar a abertura da tela principal.

---

## 8. Executar o app em dispositivo físico

1. Ativar o modo desenvolvedor no dispositivo Android.
2. Ativar a depuração USB.
3. Conectar o dispositivo ao computador.
4. Autorizar a depuração USB no aparelho.
5. Selecionar o dispositivo no Android Studio.
6. Clicar em **Run**.

---

## 9. Fluxo básico de uso

### 9.1 Tela principal

Na tela principal:

1. escolher o tipo do robô;
2. digitar uma mensagem;
3. clicar em **Enviar mensagem**.

Tipos disponíveis:

```text
Robô Básico
Robô Avançado
Robô Premium
```

### 9.2 Tela de resposta

Na tela de resposta, o app mostra:

- tipo do robô selecionado;
- mensagem enviada;
- resposta do robô;
- botão **Voltar**.

### 9.3 Retorno

Ao clicar em **Voltar** ou usar o botão voltar do Android:

- o app retorna para a tela principal;
- o campo de mensagem é limpo;
- o scroll volta para o topo.

---

## 10. Comandos aceitos

### 10.1 Robô Básico

Exemplos:

```text
Tudo bem?
EU quero testar
Eu quero testar
EU quero testar?
Olá robô
```

### 10.2 Robô Avançado

Exemplos:

```text
some 2 3
subtraia 10 4
multiplique 3 5
divida 10 2
divida 10 0
```

### 10.3 Robô Premium

Exemplo:

```text
agir
```

O comando retorna:

```text
É pra já!
```

seguido de uma frase aleatória sobre tecnologia.

---

## 11. Principais arquivos

### 11.1 Interface

```text
MainActivity.kt
AnswerActivity.kt
activity_main.xml
activity_answer.xml
```

### 11.2 Regra de negócio

```text
TipoRobo.kt
Marciano.kt
MarcianoAvancado.kt
MarcianoPremium.kt
RoboFactory.kt
UtilTexto.kt
```

### 11.3 Recursos visuais

```text
colors.xml
strings.xml
ic_robo_marciano.xml
bg_button_primary.xml
bg_input_message.xml
bg_response_card.xml
```

---

## 12. Comandos úteis do Git

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

Ver histórico:

```bash
git log --oneline
```

---

## 13. Problemas comuns

### 13.1 Erro de SDK

Caso ocorra erro relacionado ao `compileSdk`, verificar o arquivo:

```text
app/build.gradle.kts
```

E conferir se o SDK correspondente está instalado no Android Studio.

### 13.2 App fecha ao abrir

Verificar o **Logcat** no Android Studio e procurar por:

```text
FATAL EXCEPTION
```

No projeto, um erro possível durante o desenvolvimento foi o uso incorreto de `backgroundTint` junto com `background` customizado.

### 13.3 Binding não encontrado

Caso a IDE mostre erro em classes como `ActivityAnswerBinding`, tentar:

```text
File > Sync Project with Gradle Files
Build > Clean Project
Build > Rebuild Project
```

---

## 14. Resultado esperado

Ao final da execução, o app deve permitir:

- selecionar um tipo de robô;
- enviar mensagens;
- visualizar respostas corretas;
- retornar para nova interação;
- manter a regra de negócio original adaptada ao Android.
