# Starter X Mod

To jest prosty mod Fabric 1.21.4 z:
- klawiszem X do otwierania GUI
- polami na nick, host i port
- przyciskami Save i Close
- widoczną konsolą logów
- zapisem ustawień do pliku konfiguracyjnego

## Jak zainstalować

1. Pobierz plik `.jar` z repozytorium
2. Umieść go w folderze `mods` w katalogu Minecraft
3. Uruchom Minecraft z Fabric Loader 1.21.4
4. Wciśnij klawisz **X** aby otworzyć menu moda

## Jak budować projekt

Jeśli chcesz sami zbudować mod:

```bash
git clone https://github.com/Zynix-super-dev/fabric-bot-console-mod.git
cd fabric-bot-console-mod
./gradlew build
```

Plik `.jar` będzie w `build/libs/starterxmod-0.1.0.jar`

## Funkcje

- Klawisz X — otwiera menu
- Pole Nick — wpisz nick
- Pole Host — wpisz adres serwera
- Pole Port — wpisz port serwera
- Przycisk Save — zapisuje ustawienia
- Przycisk Close — zamyka menu
- Konsola — wyświetla logi działania moda

## Notatka

To jest starter bez żadnego bota czy automatyzacji. Jest to zwykły mod kliencki z konfiguracją i GUI.
