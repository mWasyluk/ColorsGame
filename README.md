# ColorsGame
A color guessing game

The object of the Game is to guess all colors automatically selected from the pool.
Once the game starts, the menu screen will be displayed. The player has three options to choose from.

![menu](https://user-images.githubusercontent.com/75240925/162182181-3f0a9ea0-1b20-4c68-822e-d162927e08b3.PNG)

The first button is responsible for generating a new pool of colors for the gameplay. The Player will see the changes right after pressing the button.

![menuNewColors](https://user-images.githubusercontent.com/75240925/162183565-9ba15c7d-c463-425c-9b27-18800451c2af.PNG)

The second button allows the Player to change the gameplay settings, these are: 
1. the number of colors in the pool of the gameplay;
2. the number of colors the Player will need to guess;
3. the number of possible tryes.

On the settings screen, the Player is able also to restore the default settings using the bottom left button or to save the selected settings using the right button.

![settingsScreen](https://user-images.githubusercontent.com/75240925/162200552-dc0f1a9b-bf8b-4351-abad-fadcd418e53e.PNG)

The input changes will be displayed on the menu screen as soon as the player confirms them with the bottom right button (the player will be automatically redirected to the menu screen).

![menuColorsMaxQuantity](https://user-images.githubusercontent.com/75240925/162201353-80317e4f-a923-4ada-8d97-0cb6a526abd3.PNG)

The third button redirects the player to the game board screen. The gameplay will start with the implemented settings.

![gameBoardView](https://user-images.githubusercontent.com/75240925/162201546-663a537e-b524-4da6-bc2a-8ac3f6a34dc4.PNG)

The player can guess the sequence selecting the corresponding colors from the circle placed in the upper right corner. Once any arc is pressed, the related color will be selected and will appear in the circle below, accroding to the order of selection.

![gameBoardView_colorsSelection](https://user-images.githubusercontent.com/75240925/162204534-000813fa-eb59-4a10-9129-88def9461063.PNG)

The player is able to undo the selection by pressing the upper left button on the right side ( below the view of selected colors ). This action can be repeated as many times as many colors have been selected.

![gameBoardView_colorsSelection_undo](https://user-images.githubusercontent.com/75240925/162206012-99678277-f1e1-4c52-8105-653e036cbff6.PNG)

Once the player has selected the required number of colors, will be able to validate them using the upper right button. The selected colors will be displayed as circles in the left pane and the numeber of remaining attempts (blue font in the bottom righ corner) will be decreased by one.

![gameBoardView_validate](https://user-images.githubusercontent.com/75240925/162207296-f05c45f3-a4f8-4d36-a7a3-2e1ce58e71c0.PNG)

To the right of these circles, a hint will be showed as the little circles which can contains one of three colors:
1. black means that one of the colors has been guessed correctly;
2. grey means that the search sequence contains one of the selected colors, but in a different place in the order;
3. white means that one of the selected colors are completely wrong.

The order of the circles in the hint means nothing, only quantity is important, for example:

![hint](https://user-images.githubusercontent.com/75240925/162211095-47cc4714-6335-4355-8b40-74e79fbe3cd4.PNG)

This hint means that two of the selected colors are correct, two are in the wrong place so the player should put them in a different order and two of the colors are incorrect, so the player should try others. The hint does not say "which" colors, but "how many" of them. 

When the last attempt remains and the player validates the wrong sequence, the game is over. An appropriate message will be displayed and the player will be able to restart the game by pressing the "Ok" button. A gameplay will be based on the same settings, but the sequence of colors will be "randomly" generated from the pool once again.

![gameBoardView_lossView](https://user-images.githubusercontent.com/75240925/162224792-a5e13f18-3e0a-4768-ba52-82664d450eae.PNG)

The player can return to the menu screen at any time using the bottom button. The gameplay settings will not change, but the colors pool will be reset to the default. The player can change the settings and start a new game.

If the player validates the correct sequence of colors, he wins the game and an appropriate message appears. As with a loss, the "Ok" button allows to restart the game with the same settings and a new sequence of colors.

![gameBoardView_winView](https://user-images.githubusercontent.com/75240925/162222699-370e18af-6a01-4dcd-ba0e-b4431453cdb5.PNG)
