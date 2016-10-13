# Assignment Two Feedback

## Group memebers: u6096655, u6096857, u5894100

## Tutor Comment
Your GUI is both welcoming and intuitive. The gameplay itself is very responsive and polished, however the hiding of the cursor while playing moves is a bit disconcerting (this may just be my machine though).

Some of the Stage initialisation code is a bit verbose and long, but appears to be well documented and shows profecient use of the APIs. Seperation into seperate classes for stages is also good.

Code is clear and well documented, both at a high level and at the statement level. There are some places where static modifiers are used inappropriately for fields, but overall your use of encapsulation and OO concepts is good.

This is a polished and well designed submission. Well done.

## Mark

### Manual mark
| Task | Description | Mark |
|:-:|---|:-:|
|8|Basic game      | 1/1 |
|9|Display scoring | .5/.5|
|11|Simple opponent| .5/.5|
|12|Good opponent  | 2/2 |

#### Manual mark 4/4


### Test results
| Task | Test | Result |
|:-:|---|:-:|
| |Compiled|1/1|
|3|TilePlacementWellFormed|5/5|
|4|PlacementWellFormed|7/7|
|6|PlacementValid|3/3|
|7|ScoreFromPlacement|1/1|
|10|GenerateMove|1/1|

#### Grade 7/7
### Deductions
| Description | Deduction |
|---|:-:|
|All files correct                | 0/-1 |
|Authorship clear for all classes | 0/-1 |
|Appropriate use of git           | 0/-1 |
|Classes compile correctly        | 0/-1 |
|Program runs from jar            | 0/-1 |
|Appropriate use of OO features   | 0/-.5 |
|Presentation pdf complete        | 0/-.5 |
|Program well designed            | 0/-.5 |
|Comments clear and sufficient    | 0/-.5 |
|Coding style good                | 0/-.5 |
|Appropriate use of JUnit tests   | 0/-.5 |
|Design and code of very high quality | 0/-.5 |
|Works well and easy to run | 0/-.5 |

#### Total deductions: 0

### Final mark 11/11
## Originality statement

* The code for music was based on the music implemented in COMP1110 Assignment 1 by Steve Blackburn
* The drum.wav sample was taken from freewavesamples.com
* Move Cursor bot from http://stackoverflow.com/questions/37500567/javafx-how-to-position-the-mouse
* Open Sans Font by Steve Matteson and commissioned by Google
* Enumeration next from http://stackoverflow.com/questions/17006239/whats-the-best-way-to-implement-next-and-previous-on-an-enum-type
* Button CSS in themes.css from http://docs.oracle.com/javafx/2/get_started/css.htm
* Calculating elapsed time for HardBot: http://memorynotfound.com/calculating-elapsed-time-java/
* Alpha-Beta Pruning based off pseudocode here: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning#Pseudocode

Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)

## Git Log
```
commit 509a779c2a87f3c51790ed88d1ff99af4e8279f3
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Oct 14 01:18:55 2016 +1100

    Add features

commit 5d29c1a8d37d27ba6dc98632d5a470e363343c14
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Oct 14 01:14:37 2016 +1100

    Add presentation and fix blocking dialog issue

commit e4991cc27fb95e702e03da5b9bb0bbccb9907bc7
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Oct 14 00:34:19 2016 +1100

    Fix scoring bug and update best code

commit 099f8afb72d8c3e85b85b1128dae61df45462df0
Author: yjl427 <u5894100@anu.edu.au>
Date:   Thu Oct 13 23:53:16 2016 +1100

    edit the G-best-u5894100

commit 1a3aebe466d05e7dd2bc6b97505d51882062813f
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Oct 13 22:37:53 2016 +1100

    best code commit

commit 301ba1d96ddc900376e0ec5aba9b66851d171597
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Oct 13 01:37:23 2016 +1100

    Add run.sh for easy opening

commit 79ebd7afbf75023afb1ea364b6c7caafa7165ccf
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Oct 13 01:35:25 2016 +1100

    Move end game scorer to Score

commit fb7c811d714593d8e3916d229c6fe8f1447116a9
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Oct 12 15:41:47 2016 +1100

    Add admin files

commit 7025fc33f47ba8e9b93571eb0971a7590fe9a102
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Oct 12 15:37:12 2016 +1100

    Fix stuff

commit 96b5c1d23fe5fcb82d28976c676fa3dec8c0de3b
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Oct 12 15:26:59 2016 +1100

    Fix everything

commit 7af7ed2f9969356311757403fcc8f6a5ca7dbde2
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 15:18:36 2016 +1100

    game.jar

commit 5e80b1250969f844cdb8b7deeef3faaf22241afb
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 15:16:53 2016 +1100

    fixed

commit 91f5c1bbac533480e175c4c54d6a7b0020bd06e4
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 15:09:36 2016 +1100

    .

commit 54e5fb2f99554ee0f577566d7f6d6896f3319c3d
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 15:06:51 2016 +1100

    Changed instructions

commit 4630e27d19c988c0a9ec0de49f67efa8fcf4badf
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 15:03:00 2016 +1100

    Changed instructions

commit 697929279b0c57afef0d30ce208514c853e127b9
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 14:34:24 2016 +1100

    Changed a key binding as well as punctuation of instructions

commit eb466672840158e15cd219d3a7fd470e5ff924f3
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Oct 12 14:25:38 2016 +1100

    Comments added

commit 5be55a0596762601306b60dc166e77635467840d
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 20:49:45 2016 +1100

    Alpha beta was called wrong previously

commit a29965f2403738efdfbe5aa68d6c138fc343e755
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 19:55:10 2016 +1100

    Commented alpha beta

commit 70c7ff268633197e8ba659c22b01bcf24fb163c1
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 19:02:53 2016 +1100

    Commented alpha beta

commit bedf8ecac6401b499db3a041da314fa763fe40f3
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 18:38:22 2016 +1100

    debugged score showing incorrectly on board

commit 55059ba17df6f2cd570feffa2a13dc1f917dfae4
Merge: 055cb3f f9d9b56
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 18:36:13 2016 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar
    #       out/production/comp1140-ass2-tue13s/comp1110/ass2/gui/Board.class
    #       src/comp1110/ass2/gui/Board.java

commit 055cb3f3252aa1c26baf2ace9155bc0d216d3d9b
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Oct 11 18:34:14 2016 +1100

    debugged score showing incorrectly in gui

commit f9d9b56ed6e52d75ac3bd4a6cbc4b9471184cffa
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Oct 11 14:10:44 2016 +1100

    Add game.jar

commit b83cc0d1ebff7e4296f5367cea3e147313bfd0e8
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Oct 11 01:00:04 2016 +1100

    Comment out Space bar placements for now

commit 61ef0b6bde50be0be0d5972c8031266a69be8d50
Merge: 741ae0c 30d2bb9
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Oct 11 00:58:36 2016 +1100

    Fix broken commit

commit 741ae0ce1ab8ea1a9976ee82389127be5ee49c6f
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Oct 11 00:56:52 2016 +1100

    Add Score tie situation, add lots of comments and FIXME

commit 30d2bb99d834e38b034c578b2f38e9084dc8c096
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Oct 10 23:43:17 2016 +1100

    Key for placing down pieces

commit c8a31f19e4d3ad2a8e2cd191a3214221baee5443
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Oct 10 20:58:05 2016 +1100

    Finished hard bot

commit ec5868f61ae08b9188dc54023eaf4e3a5abf4b39
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Oct 10 16:11:04 2016 +1100

    alpha beta

commit 67f7440781ee7b48a7ebffa8d7c0833421625fc8
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Oct 10 15:55:23 2016 +1100

    alpha beta

commit a7b76769dabe46327d9614e7005ec2b9bac4bef6
Author: Allen <allenhuang307@gmail.com>
Date:   Sun Oct 9 21:16:07 2016 +1100

    .

commit 7083375cec45b626bba23536390db4c71a0ea326
Author: Allen <allenhuang307@gmail.com>
Date:   Sat Oct 8 08:57:56 2016 +1100

    attempt at imperfect alpha beta

commit c8d498c460b5352b8b4b8408b45552f2024348e9
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Oct 7 20:21:19 2016 +1100

    Fix music

commit 45589ef609f2160c93860d1a5ad754c3be6b5798
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Oct 7 14:41:30 2016 +1100

    music

commit eb984567f674becf44480db7adc5a72be092c6b0
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Oct 7 14:32:28 2016 +1100

    Fix instructions

commit 06a3bf569c82b4bbde28d393bf1f96da65e6866b
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Oct 6 16:33:31 2016 +1100

    Fix for fonts

commit 189c3302209d29cb468d5902460ab51aaa4d8392
Merge: de9166b 1015f47
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Oct 5 20:27:46 2016 +1100

    Fixing merge

commit de9166b193d8c05bef751c17204c14e4f295ed01
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Oct 1 18:51:49 2016 +1000

    Fix merge

commit 1015f47f41164d8f46595703a6e56c3010793e20
Author: yjl427 <u5894100@anu.edu.au>
Date:   Thu Sep 29 17:01:12 2016 +1000

    Add a close button in instruction part.

commit 7b3cec31a8730ab2746d46dfc6c64342fcace0d2
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 29 14:20:16 2016 +1000

    WASD and IJKL to move and place pieces, clean up some code

commit e768449dd173a68bc4ba4b67d30c931955fa566c
Merge: 72f36fe bdc2067
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 29 13:24:23 2016 +1000

    Merge https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit 72f36fe936353dafa38d459eae35ed6df15f0ef5
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 27 17:04:51 2016 +1000

    Add change orientation on arrow buttons, music checkbox

commit 656b684c29c146883ca954ab01cf84cf43b99215
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 27 13:13:22 2016 +1000

    Fix up merge that killed menu

commit 09d1e788257cfc2cda4882a2d2eca74756d40880
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 27 12:51:20 2016 +1000

    Revert "Update JAR file for lab tomorrow"
    
    This reverts commit 38cb4cdeb4c19f1c5edfc95b8c82afd29e0dd1d2

commit 63eb704417a10232ab38b8ae8a26ece2a034ddc1
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 27 12:12:00 2016 +1000

    First edition of instruction part. Everything works fine now.

commit 8d48f7ab8495e54868fdd6557206db4732abbcb6
Merge: 959a7de 38cb4cd
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 27 12:08:33 2016 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Instructions.java
    #       src/comp1110/ass2/gui/Menu.java

commit 959a7de913f43c45c8a068827cd7037982cf4116
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 27 12:08:04 2016 +1000

    First edition of instruction part. Everything works fine now.

commit bdc20675f1aecb3665dc13755aa922bb9434bcbe
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Sep 27 06:18:16 2016 +1000

    Increase timeouts by a further 10x; they now have 100x of slack.

commit 38cb4cdeb4c19f1c5edfc95b8c82afd29e0dd1d2
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 26 18:22:27 2016 +1000

    Update JAR file for lab tomorrow

commit 2571373f6c9c5538b1321fabc15f590c9a69ec6c
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 26 18:11:20 2016 +1000

    Added hint count to option menu and fix button behaviour

commit ab3cca65172c2e3c5ad79aaeb28fde56834c9425
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 26 16:21:16 2016 +1000

    Add hints

commit 6bfcb5bb8a5195ff558141f335b1b3dd9bed4baf
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 26 12:53:45 2016 +1000

    Rename JAR file

commit ed6daef740fec9415cf1b9e629e605667a8479cb
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 26 12:43:27 2016 +1000

    Clean up code and add comments everywhere

commit 050dec19e3fdfa3699e04d1bce7f9e626875a1fb
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Sep 26 09:20:08 2016 +1000

    Add timeouts to tests

commit 12adfd2601b3decfdbdc67e61288e2f86ed2a345
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 25 16:37:54 2016 +1000

    Fix minor exit issue on Menu

commit 6dc73317bfe1fea43a60ddbef7056325a01819fc
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 25 16:35:11 2016 +1000

    Fix minor bugs, restricting depth slider

commit 32b9b55463a37699d427015ada7f7d1638ba2f86
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 25 15:13:13 2016 +1000

    UI fix and bot fix, now everything should be playable

commit 13b6263ccb6d743f7eb02ed38ac695dd8f5cf3c5
Author: Allen <allenhuang307@gmail.com>
Date:   Sat Sep 24 21:50:24 2016 +1000

    attempted alpha beta

commit 8e1b9dae506ee03ceb70ba39750af84861c8947c
Author: Allen <allenhuang307@gmail.com>
Date:   Sat Sep 24 21:08:22 2016 +1000

    debugged

commit 48756bcb42721b11fd6ad1d09669e9a2c0b47ec0
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Sep 24 15:17:22 2016 +1000

    Update heuristic function

commit 1dea7757a330c9e967c69212a1ffca0152624fc0
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Sep 24 12:21:13 2016 +1000

    Massive overhaul, minimax doesn't seem to be working though

commit 1ecdf02556235e618aff185a3be6455f3e02c2b3
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 19:17:05 2016 +1000

    fixing bugs

commit 5f4216be9b94100581d9a0df3a75d970bb7a7d61
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 18:59:20 2016 +1000

    i think it works but laggy af

commit 9ce9b89c418acf1a9c1d7009b2caba5794c272a4
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 17:50:10 2016 +1000

    finished minimax, but havent tested yet

commit ff9ff885d262969868dd0137a5a70cd0ed110855
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 17:48:50 2016 +1000

    finished minimax, but havent tested yet

commit b51a437d61dc876595eda7fcd10f57ddfba12694
Merge: f651c1e 29ebf79
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 17:31:22 2016 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/bots/HardBot.java

commit f651c1e2abec3a06b313ff99e30601eca3f61b37
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 17:30:05 2016 +1000

    unfinished minimax

commit 29ebf792da275748b8f46d4351f59839226630a5
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 17:06:02 2016 +1000

    Prepare game for Hard Bot

commit 3722bc03e0c35ade96c05c25141cd5a2727b1c9f
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 16:50:28 2016 +1000

    Merge branch 'master' of C:\Users\allen\IdeaProjects\comp1140-ass2-tue13s2 with conflicts.

commit aa78dc6c10ce1e031dc14c925e77ebad677eff66
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 16:39:00 2016 +1000

    Update GUI for modal dialog:

commit d5d5016e174e9e9e1a9601644a383df13def26c0
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 16:33:56 2016 +1000

    EasyBot with heuristic

commit f1c4e7baf6a9f478b438e7cc014e84a3848caf25
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 15:11:31 2016 +1000

    Fix up UI stuff

commit bb33da86cf1118174147a3708e57134c23583665
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 13:53:09 2016 +1000

    easybot works now...

commit ce4e54ae721e35ae354ecf1e710d6e041db4ab7e
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 12:21:05 2016 +1000

    fixed update positions, did not take into account corners before, only edges and middle spaces

commit 4d0f281cf86a0e6af410f02b5b66ccd7d4b5f6b2
Merge: 44e88e9 da37350
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 12:06:49 2016 +1000

    Merge conflicts

commit 44e88e906ecd542fab5585c670edfbf9f308c49e
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 23 11:58:01 2016 +1000

    Fix up generate moves on Bot

commit da37350c064f9e2465ca8bdb3f9ec35b18ea519e
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 11:44:07 2016 +1000

    remodified so boardstate had isGreen, and arraylist having pieces rather than bot

commit c5a9f7b948c14227a1f5b7b206cda89dd497ba52
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 11:13:57 2016 +1000

    optimisations to array of shapes to check, it used to check the same piece twice

commit 4c1916057004fcc9953973c9fa656fb753a23cc8
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 11:05:34 2016 +1000

    easy bot shud be working

commit 45700bf32c271ba08065b42cdc3e3bd28fc3b02d
Merge: 15cab13 1a0da20
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 09:10:47 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 15cab138eab919463c82e0bb53e4f355868a95ad
Author: Allen <allenhuang307@gmail.com>
Date:   Fri Sep 23 09:10:33 2016 +1000

    Fixing error

commit 1a0da204971d4cefc7fcc310d722a8087ae1b6ab
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 23:30:12 2016 +1000

    Add Instructions class for Marvin

commit 14766ccfcdb7ebc945d8597e3f3237e17c77fdd0
Merge: 7a5d444 b071dbb
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 23:19:38 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6096655/comp1140-ass2-tue13s

commit 7a5d444bfbc50248d451adcb70a41079319faef8
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 23:19:29 2016 +1000

    Open Board and Viewer as blocking dialogs

commit b071dbb3bc642d2975318cd7686a0bfbaf2bf0b3
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Sep 22 22:49:18 2016 +1000

    Finished function to generate all possible moves for a given board state

commit 10e6bdb078cb15ae375533928c3a3c2850c1da4c
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Sep 22 22:07:06 2016 +1000

    changed boardstate

commit f3f13f6d7f6141fe6820b2937a0587b226df96a9
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 17:21:28 2016 +1000

    Push first jar and update UI

commit 27633b941d5f7ea4d409581c88c7e7a1bc4d1353
Merge: f4f8450 098c02e
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Sep 22 16:58:28 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit f4f84506a3d93e271eb40e48d0bf470648d2ee96
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Sep 22 16:58:08 2016 +1000

    Ensure that valid placements always get tested in their complete form.

commit 79c7a488c1acef454f9ac9d5fbb49c9feb42f323
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Sep 22 16:56:56 2016 +1000

    Added a test to catch placements that go off the board.

commit 62b5659f8df0afdc6ac7f7e1e976614c52bbc50b
Merge: a67b663 60f6e30
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 16:21:22 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6096655/comp1140-ass2-tue13s

commit a67b6635af06448a02a515f6dfcb3c53d5cd4f94
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 22 16:21:12 2016 +1000

    UI overhaul

commit 60f6e303c94b31e867b05f9200e7838c97992870
Merge: b6957ac 5bf07ac
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 20 14:19:24 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit b6957ac21976c45af90cd02aa11b7236f02f5120
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 20 14:19:02 2016 +1000

    add test and make a few changes to the Tile and position.java

commit 5bf07ac2d43d249b6bc7899ef03cae11d1f45739
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 20 13:50:12 2016 +1000

    Fix up Board scrolling

commit 74eed32a64c04db3aae006289d380cce48228206
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 20 12:08:28 2016 +1000

    Scoring now showed for each move

commit 219e573618fabfe9f65cacd62c77e63aa8af58e7
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 20 11:28:18 2016 +1000

    Fixing Score, now works

commit eb4f60e506f0e72cc5f42ea947d89adc39724852
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Sep 20 03:01:11 2016 +1000

    almost finished and update the originality

commit b5f6f979bccffb6a9c02916fe2d13f7c96dd7f65
Author: Allen <allenhuang307@gmail.com>
Date:   Sun Sep 18 16:22:19 2016 +1000

    test for orientation

commit b99c7b955916605eb1ff9259efeb98be9bf39174
Merge: 50c7bf9 703814a
Author: Allen <allenhuang307@gmail.com>
Date:   Sun Sep 18 16:03:27 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 50c7bf9dccf3bd7a706f39ab5e957f41cc2d1756
Author: Allen <allenhuang307@gmail.com>
Date:   Sun Sep 18 16:03:02 2016 +1000

    originallity

commit 703814a9aea19e0c88b1008b5fc65305db8afdac
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 18 16:02:58 2016 +1000

    Add tests and such

commit e486e9905826b47e51a1d136f7c3c10a70362cf1
Merge: ce1f541 098c02e
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 18 15:58:49 2016 +1000

    Merge https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit 098c02e515da24ce3725b05f4030979d414fff8d
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Fri Sep 16 11:57:55 2016 +1000

    Clarify scoring

commit 769ee8a1bcc7a85a95e749671113fcff8843ae35
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Fri Sep 16 11:44:39 2016 +1000

    Fix bug in scoring.   When there is more than one region of the maximum size, the one with the greatest height should be used to calculate the score.

commit ce1f54197a254c7c6c65df4e8921dc5da0049554
Merge: fc5099e 7ce9678
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Sep 16 12:00:35 2016 +1200

    Merge https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit 7ce967876b5dbb609eff609897f3b022dfb1264e
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Thu Sep 15 21:52:47 2016 +1000

    Added tests for tasks 7 and 10

commit fc5099e3d87381b3e263cc22d96718272a830c60
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 15 20:26:14 2016 +1200

    ShapeTest for lab next week

commit bf3afe71bab02ba9bd421e187eb0556026244c73
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Sep 15 17:39:46 2016 +1200

    Update Bot for new logic

commit 32c89b764839840904ef977acd95cb3ff7c20917
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Sep 14 00:59:03 2016 +1200

    Clean up code and add end game handler

commit 59b6e942c3ea6f179cd8ab52d436d218b0dc65ec
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 13 22:47:44 2016 +1200

    Update originality statement

commit 46d25814488fe3be0e314431833f965d66b9bb76
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Sep 12 12:31:45 2016 +1200

    Add testGood for score

commit 91d6d6db81f8cd5061f6575c2ccca3aba0e7d0b1
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 23:27:40 2016 +1200

    Update scoring tests

commit b0b5bed3462ae4331e7be4a5ddb5024d4301b411
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 22:12:15 2016 +1200

    Add test for scoring

commit bfe08fd0dfafcc3852e29a6634b34cacc4f3ff1b
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 21:46:00 2016 +1200

    Placing tile over another now works - need to clean up code

commit 9d334787aa34a8c2ffc03bb9e6d0e1dc94a4ebc0
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 18:14:08 2016 +1200

    Move Cell to its own class and update colors

commit 1fd1bbe1d209e9cf8b051748f3750acbae72386a
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 12:59:24 2016 +1200

    Now supports placement on different orientations

commit c407a440dad5ddc6fac69e4a1829da83d03a923e
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 12:45:46 2016 +1200

    Now supports scroll to change orientation on hover

commit 17fa72754f963fd625b4fd93c3e5332caf7e7fda
Author: William Shen <u6096655@anu.edu.au>
Date:   Sun Sep 11 00:07:22 2016 +1200

    Hovering works - need to separate 'Cell' into its own class

commit b2ff0d3df95bd612f98365745b38718854d43c23
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Sep 10 23:46:06 2016 +1200

    Can place pieces now... Sort of ...

commit 43bfb1e64ddcd772de6c52eb6fd48c1f0a1a99f5
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Sep 10 22:26:53 2016 +1200

    Slight cleanup of labels

commit 33f1f0509e722855e6526e212c77edaf0c5e0108
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Sep 10 21:58:22 2016 +1200

    Add some GUI stuff, to show pieces

commit e17294f75f2f2299088df92ed7032e78cb771ed5
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Sep 6 23:26:56 2016 +1200

    Add BoardState and update Board for UI

commit 880b39fbc809747c7981369fa2baf7480cc5ebfe
Author: yjl427 <u5894100@anu.edu.au>
Date:   Tue Aug 30 08:13:55 2016 +1000

    originality

commit a568eebdcf819059154fd9756a9a624fa58b1a64
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Aug 29 21:59:12 2016 +1000

    originallity

commit 8191f2f835ee8035e2bf5065eab3f9c12c756fcd
Merge: 133ff7c bd3148c
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Aug 29 21:24:29 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit bd3148c7847f08e53a9c95eb2305c91474e6cc6a
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 29 21:20:02 2016 +1000

    Add originality statement

commit 133ff7cf3ecd99a28f773d290e20e15a671bb5fa
Merge: c923f6a 79b79bf
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Aug 29 20:58:13 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 79b79bf654bae4151051149ade2c98a443a615d1
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 26 22:15:18 2016 +1000

    Clean up code immensely, add new functions to Tile

commit 6c1bf53754b9ad89ad99c73d41bfaad95b84fb06
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 26 21:43:21 2016 +1000

    Add new and move class functions

commit 4360f46293d5381a5cbecc3cb9702d436528439c
Author: Benjamin George Roberts <benjamin.roberts@anu.edu.au>
Date:   Tue Aug 23 15:53:05 2016 +1000

    Stage C feedback

commit 4e7d007d48530a44f8bc8b220b81f493563f6fa6
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 23 13:16:57 2016 +1000

    Update contribution

commit fdb5627080e37ead62831e07b7e2e05a747fd5d7
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 23 12:47:45 2016 +1000

    Admin files

commit ba738bf9b810b85abe7213ee3b53b800414544d5
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 18:42:46 2016 +1000

    Clean up code - passes all tests now

commit 5fd5dde142394d71405428b09cddf4577ecccf5e
Author: yjl427 <u5894100@anu.edu.au>
Date:   Mon Aug 22 18:32:56 2016 +1000

    done the isadjacent and pass all tests

commit 45903634d7c29bd07599cc6f56804d60f974b149
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 12:36:43 2016 +1000

    Add comments for Marvin and fix tests

commit 79f1c85f41c31170a3b3e12cb2cd7c665b8c493c
Merge: 83e25da e81747c
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 12:32:48 2016 +1000

    Merge https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit e81747c45d70e73a483472df2fa68dc262411ecd
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Aug 22 12:26:29 2016 +1000

    Fixed tests to ensure that stacked placements straddle at least two tiles below, in accordance with the rules.

commit 83e25da051f1b48dbe7c1db54694a080f48d8b51
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 12:01:46 2016 +1000

    Fix for null placement string

commit f8bd6a791edaf92416b5377b2d18d643ac048ed3
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 11:22:42 2016 +1000

    Pull from upstream - for tests

commit f4cc17e05a215216bb14260d5ebe5601d9f7f3fd
Merge: 6c1b2eb a44528d
Author: William Shen <u6096655@anu.edu.au>
Date:   Mon Aug 22 11:13:40 2016 +1000

    Merge https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit a44528db6571072b8e637ac9af7f9e492f80e0d1
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Mon Aug 22 07:50:38 2016 +1000

    Added tests for tasks 3, 4, and 6.

commit c923f6afa4c1a178a67961c659223e461318b2ee
Merge: edfdc7e 6c1b2eb
Author: Allen <allenhuang307@gmail.com>
Date:   Sat Aug 20 22:18:09 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit 6c1b2ebb07334f5dd903e5e74c64029a18478414
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Aug 20 22:17:10 2016 +1000

    Minor fix

commit 1b9db81908ec90115a320369a174b02d515b75ba
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Aug 20 22:13:21 2016 +1000

    Add update to Viewer so that it displays valid heights

commit 73b96a5172406b851d26ead92909543b620d8382
Author: William Shen <u6096655@anu.edu.au>
Date:   Sat Aug 20 21:44:24 2016 +1000

    Fix up and finish Task 5

commit edfdc7ec871e7b7726641a4b68599963defe0bc4
Merge: 8431f18 d40f2e0
Author: Allen <allenhuang307@gmail.com>
Date:   Sat Aug 20 20:58:03 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit d40f2e09639be55805260a379ea0734bb96868c4
Author: yjl427 <u5894100@anu.edu.au>
Date:   Sat Aug 20 17:22:44 2016 +1000

    write down the logic for the different situations. While there is a lot duplicates, I will then try to shorten them.

commit 0a2b9b0675a1324716f02f52d5b2f468970bfc9d
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 19 21:05:23 2016 +1000

    Fix small logic fault in creating default grid

commit 25b58146f2fd44924be837817f2823e6b399ae6d
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 19 18:40:20 2016 +1000

    Add commits and clean up

commit 42c1389e6fe4a0d295367344003705ab966f3e1d
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 19 18:26:36 2016 +1000

    Small fix to clear TextField

commit 497162f09c9d14408e7e704eaea0cd10c745a248
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 19 18:25:22 2016 +1000

    Fix minor bug

commit 32e62d3e66b313366d47c4fdc534b4fba252dce2
Author: William Shen <u6096655@anu.edu.au>
Date:   Fri Aug 19 18:21:11 2016 +1000

    Lots of progress on Task 5 - only need to code piece parser

commit 26b564aa97e3cbc373609996fda36322d4f32946
Author: yjl427 <u5894100@anu.edu.au>
Date:   Fri Aug 19 16:59:04 2016 +1000

    try to use tilepane to create the pane need further working

commit bec3063e0f6333a8c656693c3181075e36d4aac4
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Aug 18 17:12:41 2016 +1000

    Add comments and description

commit 8431f186d044e6dab19d449ca109d1ae9e5f2f91
Merge: e84c71a 2071c13
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 16:34:15 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6096655/comp1140-ass2-tue13s

commit e84c71a5e681d0fd00b64c071348669b7e6ba6c9
Merge: 3c5c587 809a430
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 16:34:07 2016 +1000

    .

commit 2071c13bb2658dc89fd5f15785b9633c3bb3101b
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Aug 18 16:29:20 2016 +1000

    Fix most bugs, need to account for boundaries in 'isAdjacent'

commit 3c5c5874cedcc3c58a942347ca85b140f0eb75fa
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 14:38:07 2016 +1000

    Task 6

commit 809a4304b886bc349f1e71016923b11ec225f35b
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Aug 18 14:35:51 2016 +1000

    Cleaned up and finished Task 6 - now need to solve errors and run tests

commit 46932641496ee0a2992a7ab70f29dcbca21e4f4e
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 13:07:13 2016 +1000

    Task 6

commit 747bc619363a5a2d7eb9d4d5b1160dc44e5362b9
Merge: 0931c57 99c565c
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 13:06:54 2016 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/StratoGame.java

commit 0931c57cccd6d2af8ad4fd94444b875f364d53a9
Author: Allen <allenhuang307@gmail.com>
Date:   Thu Aug 18 12:11:50 2016 +1000

    Part of task 6

commit 99c565cb8e4e9b6b83afe2358b6302d39aad86aa
Author: William Shen <u6096655@anu.edu.au>
Date:   Thu Aug 18 00:04:31 2016 +1000

    Add rules for game

commit 78404f550971329a2419de89770b6860dc546d47
Author: William Shen <u6096655@anu.edu.au>
Date:   Wed Aug 17 23:43:40 2016 +1000

    Clean up lots of code and add methods to the enum classes

commit 1053efaf12a083d5c76b82885daf44f27f8bf392
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Aug 17 21:53:05 2016 +1000

    Part of task 6

commit 385ba624ce6b17024e6c8a50b2a886b2268027e5
Author: Allen <allenhuang307@gmail.com>
Date:   Wed Aug 17 21:35:28 2016 +1000

    Part of task 6

commit 83a88a9b4d54dad72508862b04b68ccfe4c74f59
Merge: 7d5cb9e 1502967
Author: u5894100 <u5894100@anu.edu.au>
Date:   Tue Aug 16 15:56:00 2016 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Viewer.java

commit 7d5cb9e7a2fcdc21f8f4fdbae30def4b7db06da1
Author: u5894100 <u5894100@anu.edu.au>
Date:   Tue Aug 16 15:54:42 2016 +1000

    part of t5

commit 150296709baba12d902ba221528724b45db053e8
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 15:33:12 2016 +1000

    Remove unneeded constant

commit 26ec610ddff3eec420c4fa69a55fba6b6762b131
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 15:21:36 2016 +1000

    Clean up and finish Task 4

commit 8ada8995c16554c580dd704bfe77ee84e0dde6c6
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 14:55:15 2016 +1000

    Task 4 rough complete

commit 4cf06164ca782ff6607d15603b339c75e33e0fba
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 14:22:53 2016 +1000

    Add work on Task 4

commit 81a552e82452a0f5e621ad6c987aad54c0fb6ecc
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 14:06:34 2016 +1000

    Remove gittest - lab exercise

commit 1a7efa1b144e2b1aac63196ef77aee81adfa39e6
Merge: 7bffe55 a661315
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 13:38:44 2016 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gittest/Main.java

commit 7bffe558a26d43f92e59e79237cbda3d10ce5179
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 13:36:55 2016 +1000

    update main B

commit a6613152dd0bda38cce1807a70be7cd2cf0588be
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:35:34 2016 +1000

    Add a and c objects to Main

commit 6a312ba3c8e57ac03dfa884d7b1da7a12ece8002
Merge: 7b679d5 f402741
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 13:30:53 2016 +1000

    Merge remote-tracking branch 'origin/master'

commit f40274164549fa95ebac1f0dbe75944cadce63e1
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:30:20 2016 +1000

    Add C class

commit 7b679d52384861440b8c287b7581fe9b94ac6225
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 13:30:12 2016 +1000

    B

commit 0856c130eba17229b71363a7c5184ca2e0aefb51
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:29:16 2016 +1000

    Add gittest and classes

commit 8d504be51de204d9255544c5c27df0bb65113412
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:28:02 2016 +1000

    Revert gittest package

commit b0fae330f0ed3639e0ccb63ad3b73fbbddb5dbb3
Merge: 13e1917 1f44a23
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:27:41 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6096655/comp1140-ass2-tue13s

commit 13e191778e6c38204c9ff9262cfed91141c80b8b
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:25:56 2016 +1000

    Revert accidental gittest package

commit b129f4e574a1af307892593cc59818ee2a50de83
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:23:02 2016 +1000

    Add C class

commit 1f44a23996833e89b6d28cb572929e5a890edbfd
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 16 13:22:08 2016 +1000

    B gittest

commit d100a392171c8592f718e31b8e05850f9b31db26
Author: William Shen <u6096655@anu.edu.au>
Date:   Tue Aug 16 13:20:11 2016 +1000

    Add gittest package

commit 95a42d731c08bbe7ccd67d4978916e7de60ac5ce
Merge: 44259d6 dcc4ca5
Author: William Shen <William Shen>
Date:   Tue Aug 16 11:46:28 2016 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1140-ass2

commit 44259d6ff74a0ec6f1e02db81525257895b5a63f
Author: William Shen <William Shen>
Date:   Mon Aug 15 22:08:13 2016 +1000

    Add UML and fix some classes

commit 173aab93266361ad2bb4126b6897bf64362cd7ee
Author: yjl427 <u5894100@anu.edu.au>
Date:   Mon Aug 15 19:41:20 2016 +1000

    Marvin: done the score.

commit 2f588a818d30c3c2511f2987b9628bf447eaa94b
Author: William Shen <William Shen>
Date:   Mon Aug 15 18:20:25 2016 +1000

    Design for a 'Tile' added with unimplemented methods

commit ce9a639cf554cedf9456099a66cc93aabf30c0f2
Author: Allen <allenhuang307@gmail.com>
Date:   Mon Aug 15 17:45:17 2016 +1000

    Update

commit df0dd83740c02e0d897ffadc86cf6cd44e97e748
Author: William Shen <William Shen>
Date:   Mon Aug 15 14:54:29 2016 +1000

    Add Bot and Logic classes

commit 54b79bc545b1609eb030e0a042b4cafc62829d20
Author: William Shen <William Shen>
Date:   Wed Aug 10 10:25:22 2016 +1000

    Pull from upstream

commit dcc4ca54fb01879ea421ac0f7f55951609504cc3
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Wed Aug 10 06:55:32 2016 +1000

    Update README.md

commit 5372d09625128ff8c6ea9805f0eb7e1e7f65fb40
Author: Allen <allenhuang307@gmail.com>
Date:   Tue Aug 9 15:48:08 2016 +1000

    Task 4 check each set of 4 valid

commit 12f9feed3e711d7a92eb7d312e848f8c3b6fca39
Author: William Shen <William Shen>
Date:   Tue Aug 9 15:40:20 2016 +1000

    Update Task 3 and add .idea

commit 22091fa39ce732ebcaab06355f07455f6e927c51
Author: William Shen <William Shen>
Date:   Tue Aug 9 15:30:32 2016 +1000

    Add UML and clean up Task 3

commit 5ce3f8b16c600300e6ffc92cc6b0a298fd97e355
Author: Allen <u6096857@anu.edu.au>
Date:   Tue Aug 9 15:21:33 2016 +1000

    Task 3 complete

commit 996baceb24309034ca95be7404289a850dd1b695
Author: William Shen <William Shen>
Date:   Tue Aug 9 14:45:16 2016 +1000

    Update General Info in Admin - again

commit 62a496a44782a03100d7450614655dfd8ed98fae
Author: William Shen <William Shen>
Date:   Tue Aug 9 14:44:33 2016 +1000

    Update General Info in Admin

commit 990e2bd9d1b7f72cfe98938fd10eb9614167e06d
Author: Allen <u6096857@anu.edu.au>
Date:   Tue Aug 9 14:41:38 2016 +1000

    update

commit a5678acf818f5e4f1deab16a7926026dc0dea1e5
Author: William Shen <William Shen>
Date:   Tue Aug 9 14:37:03 2016 +1000

    Add General Administrative Information

commit 88186a253ff9452256a764b0e1d4698817611c4e
Author: COMP1110 Sem 2 2016 <steve.blackburn+comp1110-2016@anu.edu.au>
Date:   Tue Aug 9 12:47:52 2016 +1000

    Initial import
```
## Changes
```
Only in ../master/comp1140-ass2/.idea: .name
Only in comp1140-ass2/.idea: artifacts
Only in ../master/comp1140-ass2/.idea: comp1140-ass2.iml
Only in comp1140-ass2/.idea: dictionaries
diff -ru -x .git ../master/comp1140-ass2/.idea/misc.xml comp1140-ass2/.idea/misc.xml
--- ../master/comp1140-ass2/.idea/misc.xml	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/.idea/misc.xml	2016-10-15 14:04:03.000000000 +1100
@@ -3,13 +3,6 @@
   <component name="EntryPointsManager">
     <entry_points version="2.0" />
   </component>
-  <component name="MavenImportPreferences">
-    <option name="generalSettings">
-      <MavenGeneralSettings>
-        <option name="mavenHome" value="Bundled (Maven 3)" />
-      </MavenGeneralSettings>
-    </option>
-  </component>
   <component name="ProjectLevelVcsManager" settingsEditedManually="false">
     <OptionsSetting value="true" id="Add" />
     <OptionsSetting value="true" id="Remove" />
@@ -23,4 +16,5 @@
   <component name="ProjectRootManager" version="2" languageLevel="JDK_1_8" default="true" assert-keyword="true" jdk-15="true" project-jdk-name="1.8" project-jdk-type="JavaSDK">
     <output url="file://$PROJECT_DIR$/out" />
   </component>
+  <component name="WebServicesPlugin" addRequiredLibraries="true" />
 </project>
\ No newline at end of file
diff -ru -x .git ../master/comp1140-ass2/.idea/modules.xml comp1140-ass2/.idea/modules.xml
--- ../master/comp1140-ass2/.idea/modules.xml	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/.idea/modules.xml	2016-10-15 14:04:03.000000000 +1100
@@ -2,7 +2,7 @@
 <project version="4">
   <component name="ProjectModuleManager">
     <modules>
-      <module fileurl="file://$PROJECT_DIR$/.idea/comp1140-ass2.iml" filepath="$PROJECT_DIR$/.idea/comp1140-ass2.iml" />
+      <module fileurl="file://$PROJECT_DIR$/comp1140-ass2-tue13s.iml" filepath="$PROJECT_DIR$/comp1140-ass2-tue13s.iml" />
     </modules>
   </component>
-</project>
+</project>
\ No newline at end of file
diff -ru -x .git ../master/comp1140-ass2/README.md comp1140-ass2/README.md
--- ../master/comp1140-ass2/README.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/README.md	2016-10-15 14:04:03.000000000 +1100
@@ -277,4 +277,4 @@
 <a name="2hd"></a>
 **High Distinction**
 * _All of the Distinction-level criteria, plus the following..._
-* Task #12.
+* Task #12.
\ No newline at end of file
Only in comp1140-ass2/admin: A-GeneralInformation.md
diff -ru -x .git ../master/comp1140-ass2/admin/B-contribution.md comp1140-ass2/admin/B-contribution.md
--- ../master/comp1140-ass2/admin/B-contribution.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/B-contribution.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6096655 33.333...
+* u6096857 33.333...
+* u5894100 33.333...
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
\ No newline at end of file
diff -ru -x .git ../master/comp1140-ass2/admin/B-originality.md comp1140-ass2/admin/B-originality.md
--- ../master/comp1140-ass2/admin/B-originality.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/B-originality.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work,
+except for the class 'Shape' and 'PlayGame' where inspiration was taken from COMP1110 Assignment 1 2016 by Steve Blackburn. 
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
diff -ru -x .git ../master/comp1140-ass2/admin/C-contribution.md comp1140-ass2/admin/C-contribution.md
--- ../master/comp1140-ass2/admin/C-contribution.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/C-contribution.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage C was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6096655 37.5
+* u6096857 37.5
+* u5894100 25
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
\ No newline at end of file
Only in comp1140-ass2/admin: C-feedback.md
diff -ru -x .git ../master/comp1140-ass2/admin/C-originality.md comp1140-ass2/admin/C-originality.md
--- ../master/comp1140-ass2/admin/C-originality.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/C-originality.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,9 +1,3 @@
 We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
Only in ../master/comp1140-ass2/admin: D-originality-u1234567.md
Only in comp1140-ass2/admin: D-originality-u5894100.md
Only in comp1140-ass2/admin: D-originality-u6096655.md
Only in comp1140-ass2/admin: D-originality-u6096857.md
Only in ../master/comp1140-ass2/admin: E-originality-u1234567.md
Only in comp1140-ass2/admin: E-originality-u5894100.md
Only in comp1140-ass2/admin: E-originality-u6096655.md
Only in comp1140-ass2/admin: E-originality-u6096857.md
diff -ru -x .git ../master/comp1140-ass2/admin/F-contribution.md comp1140-ass2/admin/F-contribution.md
--- ../master/comp1140-ass2/admin/F-contribution.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/F-contribution.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,8 +1,7 @@
 We declare that the work toward our submission of Stage F was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* u6096655 40
+* u6096857 30
+* u5894100 30
 
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
diff -ru -x .git ../master/comp1140-ass2/admin/F-originality.md comp1140-ass2/admin/F-originality.md
--- ../master/comp1140-ass2/admin/F-originality.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/F-originality.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,9 +1,11 @@
 We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+* Enumeration next from http://stackoverflow.com/questions/17006239/whats-the-best-way-to-implement-next-and-previous-on-an-enum-type
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
+* Button CSS in themes.css from http://docs.oracle.com/javafx/2/get_started/css.htm
 
-* ....
+* Calculating elapsed time for HardBot: http://memorynotfound.com/calculating-elapsed-time-java/
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* Alpha-Beta Pruning based off pseudocode here: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning#Pseudocode
+
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
Only in ../master/comp1140-ass2/admin: G-best-u1234567.md
Only in comp1140-ass2/admin: G-best-u5894100.md
Only in comp1140-ass2/admin: G-best-u6096655.md
Only in comp1140-ass2/admin: G-best-u6096857.md
diff -ru -x .git ../master/comp1140-ass2/admin/G-contribution.md comp1140-ass2/admin/G-contribution.md
--- ../master/comp1140-ass2/admin/G-contribution.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/G-contribution.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,8 +1,7 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* u6096655 40
+* u6096857 40
+* u5894100 20
 
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
diff -ru -x .git ../master/comp1140-ass2/admin/G-features.md comp1140-ass2/admin/G-features.md
--- ../master/comp1140-ass2/admin/G-features.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/G-features.md	2016-10-15 14:04:03.000000000 +1100
@@ -12,3 +12,15 @@
  - Advanced computer opponent
 
 additional features...
+ - Options menu
+ - Music
+ - Hints for human players (can set limit to this)
+ - Instruction and Help Window/Messages
+ - Useful confirmation and warning messages
+ - Advanced computer opponent difficulty selection
+ - Probabilistic advanced computer opponent
+ - Advanced and Modern GUI interface (with the help of CSS)
+ - Easy to use and intuitive UI
+ - Bot vs Bot capability
+ - Keyboard Support for human players
+ - Tile placement hover preview for human players
\ No newline at end of file
diff -ru -x .git ../master/comp1140-ass2/admin/G-originality.md comp1140-ass2/admin/G-originality.md
--- ../master/comp1140-ass2/admin/G-originality.md	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/admin/G-originality.md	2016-10-15 14:04:03.000000000 +1100
@@ -1,9 +1,12 @@
 We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+* The code for music was based on the music implemented in COMP1110 Assignment 1 by Steve Blackburn
+* The drum.wav sample was taken from freewavesamples.com
+* Move Cursor bot from http://stackoverflow.com/questions/37500567/javafx-how-to-position-the-mouse
+* Open Sans Font by Steve Matteson and commissioned by Google
+* Enumeration next from http://stackoverflow.com/questions/17006239/whats-the-best-way-to-implement-next-and-previous-on-an-enum-type
+* Button CSS in themes.css from http://docs.oracle.com/javafx/2/get_started/css.htm
+* Calculating elapsed time for HardBot: http://memorynotfound.com/calculating-elapsed-time-java/
+* Alpha-Beta Pruning based off pseudocode here: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning#Pseudocode
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: William Shen (u6096655), Allen Huang (u6096857), and Marvin Yang (u5894100)
Only in comp1140-ass2: comp1140-ass2-tue13s.iml
Only in comp1140-ass2: feedback.md
Only in comp1140-ass2: game.jar
Only in comp1140-ass2: out
Only in comp1140-ass2: presentation.pdf
Only in comp1140-ass2: run.bat
Only in comp1140-ass2: run.sh
Only in comp1140-ass2/src: META-INF
diff -ru -x .git ../master/comp1140-ass2/src/comp1110/ass2/StratoGame.java comp1140-ass2/src/comp1110/ass2/StratoGame.java
--- ../master/comp1140-ass2/src/comp1110/ass2/StratoGame.java	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/src/comp1110/ass2/StratoGame.java	2016-10-15 14:04:03.000000000 +1100
@@ -1,5 +1,9 @@
 package comp1110.ass2;
 
+import comp1110.ass2.logic.*;
+
+import java.util.Arrays;
+
 /**
  * This class provides the text interface for the Strato Game
  *
@@ -7,6 +11,9 @@
  * (http://boardgamegeek.com/boardgame/125022/stratopolis)
  */
 public class StratoGame {
+    
+    private static final int TILE_PLACEMENT_LENGTH = 4;
+    private static final int MAX_TILE_PLACEMENTS = 41;
 
     /**
      * Determine whether a tile placement is well-formed according to the following:
@@ -20,8 +27,19 @@
      * @return True if the tile placement is well-formed
      */
     static boolean isTilePlacementWellFormed(String tilePlacement) {
-        // FIXME Task 3: determine whether a tile placement is well-formed
-        return false;
+        // Return false if length of string does not equal 4
+        if (tilePlacement.length() != TILE_PLACEMENT_LENGTH)
+            return false;
+
+        // Read in characters at their positions in the string
+        char c1 = tilePlacement.charAt(0);
+        char c2 = tilePlacement.charAt(1);
+        char c3 = tilePlacement.charAt(2);
+        char c4 = tilePlacement.charAt(3);
+
+        // Compare the characters to the relevant conditions and return
+        return (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z' &&
+                c3 >= 'A' && c3 <= 'U' && c4 >= 'A' && c4 <= 'D');
     }
 
     /**
@@ -37,9 +55,69 @@
      * @return True if the placement is well-formed
      */
     static boolean isPlacementWellFormed(String placement) {
-        // FIXME Task 4: determine whether a placement is well-formed
-        String foo;
-        return false;
+        // We don't want to parse a null string...
+        if (placement == null) return false;
+
+        // We check the placement string length is a multiple of 4, is non-empty, and contains a maximum of 41
+        if (placement.length() % TILE_PLACEMENT_LENGTH != 0 ||
+            placement.length() == 0 ||
+            placement.length() > TILE_PLACEMENT_LENGTH * MAX_TILE_PLACEMENTS) {
+            return false;
+        }
+
+        // i is our index in the string. We check that the first tile placement is 'MMUA'
+        if (!(placement.substring(0, 4).equals("MMUA"))) {
+            return false;
+        }
+
+        // If the length of the placement string is 4, then it only contains 'MMUA'
+        if (placement.length() == 4) return true;
+
+        // The flag used to indicate which player's piece we expect next
+        boolean isGreen = true;
+
+        /** The array used to store the count of pieces. Recall that the characters 'A' to 'T'
+         *  represent the Green and Red Player's Pieces. This means there are 20 pieces.
+         *  We initialise the array to 2, as we subtract 1 each time we encounter a piece.
+         *  Therefore, if we encounter a 0 as an element, we know there have been 2 pieces
+         *  of a same type already.
+         *  Index 0 refers to 'A', 1 refers to 'B', ... , 19 refers to 'T'
+         */
+        int[] letterCount = new int[20];
+        Arrays.fill(letterCount, 2);
+
+        // Here we loop through the placement string excluding the first tile placement
+        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
+            if (!isTilePlacementWellFormed(placement.substring(i, i+4)))
+                return false;
+            // The third character in a tile placement - i.e. the piece ID
+            char pieceID = placement.charAt(i+2);
+            if (isGreen) {
+                // We check that the piece belongs to the Green Player
+                if (!(pieceID >= 'K' && pieceID <= 'T')) return false;
+                // We check if there have been 2 of the same pieces already
+                if (letterCount[pieceID - 'A'] == 0) {
+                    return false;
+                } else {
+                    letterCount[pieceID - 'A'] -= 1;
+                }
+                // Alternate players - now it's Red's turn
+                isGreen = false;
+            } else {
+                // We check that the piece belongs to the Red Player
+                if (!(pieceID >= 'A' && pieceID <= 'J')) return false;
+                // We check if there have been 2 of the same pieces already
+                if (letterCount[pieceID - 'A'] == 0) {
+                    return false;
+                } else {
+                    letterCount[pieceID - 'A'] -= 1;
+                }
+                // Alternate players - now it is Green's turn
+                isGreen = true;
+            }
+        }
+        // The placement string passes all the tests
+        return true;
     }
 
     /**
@@ -49,9 +127,30 @@
      * @param placement A placement string
      * @return True if the placement is valid
      */
-    static boolean isPlacementValid(String placement) {
-        // FIXME Task 6: determine whether a placement is valid
-        return false;
+    public static boolean isPlacementValid(String placement) {
+        // We first check if the input Placement String is well-formed itself
+        if (!isPlacementWellFormed(placement)) return false;
+        // If the placement string is just 'MMUA'
+        if (placement.equals("MMUA")) return true;
+
+        // Create a new BoardState instance
+        BoardState boardState = new BoardState();
+
+        /* Loop over the rest of the placement string, bar "MMUA" */
+        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
+            // Create a new tile from the placement string
+            Tile substringTile = new Tile(new Position(placement.charAt(i), placement.charAt(i+1)),
+                                          Shape.fromChar(placement.charAt(i+2)),
+                                          Orientation.fromChar(placement.charAt(i+3)));
+            // We check if all the rules are fulfilled. If so, then update the arrays and continue looping
+            if (boardState.isTileValid(substringTile)) {
+                    boardState.addTile(substringTile); // update the board state
+            } else {
+                return false;
+            }
+        }
+        // When we are here, the whole placement string has been parsed and is thus valid
+        return true;
     }
 
     /**
@@ -63,9 +162,13 @@
      *              otherwise the score for the red player should be returned
      * @return the score for the requested player, given the placement
      */
-    static int getScoreForPlacement(String placement, boolean green) {
-        // FIXME Task 7: determine the score for a player given a placement
-        return 0;
+     static int getScoreForPlacement(String placement, boolean green) {
+        // If the placement is invalid, the score is 0
+        if (!isPlacementValid(placement)) return 0;
+
+        // Create a new board state and get the score
+        BoardState board = new BoardState(placement);
+        return board.getScore(green);
     }
 
     /**
@@ -78,7 +181,7 @@
      * @return A string indicating a valid tile placement that represents your move.
      */
     static String generateMove(String placement, char piece, char opponentsPiece) {
-        // FIXME Task 10: generate a valid move
-        return null;
+        BoardState game = new BoardState(placement);
+        return game.generatePossibleMoves(Shape.fromChar(piece)).getFirst().toString();
     }
 }
Only in comp1140-ass2/src/comp1110/ass2: bots
diff -ru -x .git ../master/comp1140-ass2/src/comp1110/ass2/gui/Board.java comp1140-ass2/src/comp1110/ass2/gui/Board.java
--- ../master/comp1140-ass2/src/comp1110/ass2/gui/Board.java	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/src/comp1110/ass2/gui/Board.java	2016-10-15 14:04:03.000000000 +1100
@@ -1,22 +1,800 @@
 package comp1110.ass2.gui;
 
-import javafx.application.Application;
+import comp1110.ass2.logic.Player;
+import comp1110.ass2.logic.Shape;
+import javafx.application.Platform;
+import javafx.geometry.Point2D;
+import javafx.geometry.Pos;
+import javafx.scene.Cursor;
+import javafx.scene.Group;
+import javafx.scene.Scene;
+import javafx.scene.control.Alert;
+import javafx.scene.control.Button;
+import javafx.scene.control.ButtonType;
+import javafx.scene.control.Label;
+import javafx.scene.image.Image;
+import javafx.scene.input.KeyCode;
+import javafx.scene.layout.Region;
+import javafx.scene.layout.VBox;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Font;
+import javafx.scene.text.FontWeight;
+import comp1110.ass2.logic.*;
+import comp1110.ass2.bots.*;
+import javafx.stage.Modality;
 import javafx.stage.Stage;
 
-public class Board extends Application {
+import java.awt.*;
+import java.util.*;
+
+/**
+ * `Board` is the window in which games are played, it is
+ * initialised in Menu.
+ *
+ * @author William Shen - u6096655
+ */
+class Board extends Stage {
+    /* Constants */
     private static final int BOARD_WIDTH = 933;
-    private static final int BOARD_HEIGHT = 700;
+    private static final int BOARD_HEIGHT = 720;
+    private static final int GRID_SIZE = 26;
+    // In pixels, used to help layout
+    private static final int CELL_SIZE = 26;
+    private static final int X_OFFSET = 135;
+    private static final int Y_OFFSET = 45;
+
+    /* Variables for JavaFX */
+    private final Stage primaryStage = new Stage();
+    private final Group root = new Group();
+    private final Group greenCurrentTile = new Group();
+    private final Group greenNextTile = new Group();
+    private final Group redCurrentTile = new Group();
+    private final Group redNextTile = new Group();
+    private final Group hoverCurrentTile = new Group();
+    private final Group hintTile = new Group();
+
+    private Label greenPiecesLeft = new Label();
+    private Label redPiecesLeft = new Label();
+    private Label playerTurn = new Label();
+
+    private Button greenHint = new Button();
+    private Button redHint = new Button();
+    private Label greenHintLbl;
+    private Label redHintLbl;
+
+    /* Class variables to store the board, and associated options */
+    private BoardState boardState = new BoardState();
+    private Player greenState;
+    private Player redState;
+    private int greenDifficulty;
+    private int redDifficulty;
+    private int hintCount;
+    private int greenHintCount;
+    private int redHintCount;
+    private Orientation hoverOrientation = Orientation.A;
+
+    /* Prepare everything accordingly for play */
+    private void setupGame() {
+        // Large box identifiers - i.e. panels
+        Rectangle greenPanel = new Rectangle(X_OFFSET, 752);
+        greenPanel.setFill(Color.GREEN);
+        greenPanel.setOpacity(0.3);
+        Rectangle redPanel = new Rectangle(X_OFFSET, 752);
+        redPanel.setFill(Color.RED);
+        redPanel.setOpacity(0.3);
+        redPanel.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
+        Rectangle greyPanelTop = new Rectangle(GRID_SIZE * CELL_SIZE, 45);
+        greyPanelTop.setFill(Color.GREY);
+        greyPanelTop.setOpacity(0.2);
+        greyPanelTop.setTranslateX(X_OFFSET);
+        root.getChildren().addAll(greenPanel, redPanel, greyPanelTop);
+        // Place labels to identify players. If they are bot we label the bot's difficulty
+        Label greenPlayer = (greenState.isHuman()) ? new Label("Player Green")
+                : new Label(greenState.toString());
+        greenPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
+        greenPlayer.setPrefWidth(X_OFFSET);
+        greenPlayer.setAlignment(Pos.CENTER);
+        greenPlayer.setTranslateY(10);
+        Label redPlayer = (redState.isHuman()) ? new Label("Player Red")
+                : new Label(redState.toString());
+        redPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
+        redPlayer.setPrefWidth(X_OFFSET - 5);
+        redPlayer.setAlignment(Pos.CENTER);
+        redPlayer.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
+        redPlayer.setTranslateY(10);
+        // Set up the 'pieces left' labels
+        greenPiecesLeft.setFont(Font.font("Open Sans", 16));
+        greenPiecesLeft.setPrefWidth(X_OFFSET);
+        greenPiecesLeft.setAlignment(Pos.CENTER);
+        greenPiecesLeft.setTranslateY(180);
+        redPiecesLeft.setFont(Font.font("Open Sans", 16));
+        redPiecesLeft.setPrefWidth(X_OFFSET);
+        redPiecesLeft.setAlignment(Pos.CENTER);
+        redPiecesLeft.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE - 5);
+        redPiecesLeft.setTranslateY(180);
+        // Set up the main status label on the screen
+        playerTurn.setFont(Font.font("System", FontWeight.BOLD, 18));
+        playerTurn.setPrefWidth(BOARD_WIDTH - 2 * X_OFFSET);
+        playerTurn.setTranslateX(X_OFFSET+5);
+        playerTurn.setTranslateY(10);
+        playerTurn.setAlignment(Pos.CENTER);
+        root.getChildren().addAll(greenPlayer, redPlayer, greenPiecesLeft, redPiecesLeft, playerTurn);
+        // Setup hints if the player is human and we have allocated hints
+        if (greenState.isHuman() && greenHintCount != 0) {
+            // Set up labels and buttons
+            greenHintLbl = new Label("Hints Left: " + greenHintCount);
+            greenHintLbl.setPrefWidth(X_OFFSET);
+            greenHintLbl.setAlignment(Pos.CENTER);
+            greenHintLbl.setFont(Font.font(16));
+            greenHintLbl.setTranslateY(BOARD_HEIGHT - 85);
+            greenHint = new Button("Hint");
+            greenHint.setId("control-btn");
+            greenHint.setPrefWidth(80);
+            greenHint.setTranslateX(27);
+            greenHint.setTranslateY(BOARD_HEIGHT - 50);
+            root.getChildren().addAll(greenHintLbl, greenHint);
+            // Show hint by using EasyBot
+            greenHint.setOnAction(event -> {
+                if (greenHintCount == 0) {
+                    greenHint.setDisable(true);
+                    return;
+                }
+                greenHint.setDisable(true);
+                EasyBot hint = new EasyBot(boardState, true);
+                showHint(hint.getMove());
+                greenHintLbl.setText("Hints Left: " + --greenHintCount);
+            });
+        }
+        if (redState.isHuman() && redHintCount != 0) {
+            // Set up labels and buttons
+            redHintLbl = new Label("Hints Left: " + redHintCount);
+            redHintLbl.setPrefWidth(X_OFFSET);
+            redHintLbl.setAlignment(Pos.CENTER);
+            redHintLbl.setFont(Font.font(16));
+            redHintLbl.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
+            redHintLbl.setTranslateY(BOARD_HEIGHT - 85);
+            redHint = new Button("Hint");
+            redHint.setDisable(true);
+            redHint.setId("control-btn");
+            redHint.setPrefWidth(80);
+            redHint.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE + 27);
+            redHint.setTranslateY(BOARD_HEIGHT - 50);
+            root.getChildren().addAll(redHintLbl, redHint);
+            // Show hint by using EasyBot
+            redHint.setOnAction(event -> {
+                if (redHintCount == 0) {
+                    redHint.setDisable(true);
+                    return;
+                }
+                redHint.setDisable(true);
+                EasyBot hint = new EasyBot(boardState, false);
+                showHint(hint.getMove());
+                redHintLbl.setText("Hints Left: " + --redHintCount);
+            });
+        }
+        // Initialise the 'deck' of tiles for the players and display them
+        setupPlayerTiles();
+    }
+
+    private void setupPlayerTiles() {
+        // Create the pieces for the players
+        boardState.createPlayerPieces();
+        // Show the tile previews and disable red player hint button for green's turn
+        previewTiles(true);
+        previewTiles(false);
+        redHint.setDisable(true);
+        // Set player's turn
+        playerTurn.setTextFill(Color.GREEN);
+        playerTurn.setText("Green Player's Turn");
+    }
+
+    private void previewTiles(boolean isGreenTurn) {
+        // Set up variables for ease of use
+        LinkedList<Shape> greenShapes = boardState.getGreenShapes();
+        LinkedList<Shape> redShapes = boardState.getRedShapes();
+
+        greenPiecesLeft.setText(greenShapes.size() + " piece(s) left"
+                + "\nScore = " + boardState.getScore(true));
+        redPiecesLeft.setText(redShapes.size() + " piece(s) left"
+                + "\nScore = " + boardState.getScore(false));
+
+        // Show how many pieces a player has left and the current score
+        if (isGreenTurn) {
+            playerTurn.setTextFill(Color.RED);
+            playerTurn.setText("Red Player's Turn");
+            if (redHintCount != 0) redHint.setDisable(false);
+            greenHint.setDisable(true);
+            greenNextTile.setVisible(false);
+            redNextTile.setVisible(true);
+        } else {
+            playerTurn.setTextFill(Color.GREEN);
+            playerTurn.setText("Green Player's Turn");
+            if (greenHintCount != 0) greenHint.setDisable(false);
+            redHint.setDisable(true);
+            redNextTile.setVisible(false);
+            greenNextTile.setVisible(true);
+        }
+        
+        // Check if we are approaching the end game state, if so translate pieces left labels accordingly
+        if (isGreenTurn && greenShapes.isEmpty()) {
+            // Green runs out of pieces
+            root.getChildren().remove(greenCurrentTile);
+            greenPiecesLeft.setTranslateY(45);
+            return;
+        } else if (redShapes.isEmpty()) {
+            // Red runs out of pieces, end of game
+            root.getChildren().remove(redCurrentTile);
+            redPiecesLeft.setTranslateY(45);
+            return;
+        }
+
+        // We create a new preview cell based on whose turn it is
+        if (isGreenTurn) showCurrentTile(greenShapes.getFirst(), true);
+        else showCurrentTile(redShapes.getFirst(), false);
+
+        // Add next tile to preview or move the `Pieces Left` label
+        if (greenShapes.size() == 1 && isGreenTurn) {
+            root.getChildren().remove(greenNextTile);
+            greenPiecesLeft.setTranslateY(110);
+        } else if (redShapes.size() == 1) {
+            root.getChildren().remove(redNextTile);
+            redPiecesLeft.setTranslateY(110);
+        } else {
+            // Get the next shape after the current one - i.e. player has picked up current shape
+            Shape shape = (isGreenTurn) ? greenShapes.get(1) : redShapes.get(1);
+            showNextTile(shape, isGreenTurn);
+        }
+    }
+
+    private void showCurrentTile(Shape shape, boolean isGreen) {
+        // Create new cells
+        Cell zero = new Cell(shape.colourAtIndex(0));
+        Cell one = new Cell(shape.colourAtIndex(1));
+        Cell two = new Cell(shape.colourAtIndex(2));
+
+        // Remove existing tile and add new one to root
+        if (isGreen) {
+            root.getChildren().remove(greenCurrentTile);
+            greenCurrentTile.getChildren().clear();
+            // Set up position of cells on screen
+            zero.setTranslateX(41); zero.setTranslateY(50);
+            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(50);
+            two.setTranslateX(41); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
+            greenCurrentTile.getChildren().addAll(zero, one, two);
+            root.getChildren().add(greenCurrentTile);
+        } else {
+            root.getChildren().remove(redCurrentTile);
+            redCurrentTile.getChildren().clear();
+            // Set up position of cells on screen
+            zero.setTranslateX(X_OFFSET + GRID_SIZE * CELL_SIZE + 41); zero.setTranslateY(50);
+            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(50);
+            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
+            redCurrentTile.getChildren().addAll(zero, one, two);
+            root.getChildren().add(redCurrentTile);
+        }
+    }
+
+    private void showNextTile(Shape shape, boolean isGreen) {
+        // Create new cells
+        Cell zero = new Cell(shape.colourAtIndex(0));
+        Cell one = new Cell(shape.colourAtIndex(1));
+        Cell two = new Cell(shape.colourAtIndex(2));
+
+        // Removing existing tile and add new one to root
+        if (isGreen) {
+            root.getChildren().remove(greenNextTile);
+            greenNextTile.getChildren().clear();
+            // Set up position of cells on screen
+            zero.setTranslateX(41); zero.setTranslateY(115);
+            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(115);
+            two.setTranslateX(41); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
+            greenNextTile.getChildren().addAll(zero, one, two);
+            greenNextTile.setOpacity(0.55);
+            root.getChildren().add(greenNextTile);
+        } else {
+            root.getChildren().remove(redNextTile);
+            redNextTile.getChildren().clear();
+            // Set up position of cells on screen
+            zero.setTranslateX(X_OFFSET + GRID_SIZE * CELL_SIZE + 41); zero.setTranslateY(115);
+            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(115);
+            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
+            redNextTile.getChildren().addAll(zero, one, two);
+            redNextTile.setOpacity(0.55);
+            root.getChildren().add(redNextTile);
+        }
+    }
+
+    private void endGame() {
+        // Update label scores - ensure nothing goes wrong
+        greenPiecesLeft.setText("0 pieces left \nScore = " + boardState.getScore(true));
+        redPiecesLeft.setText("0 pieces left \nScore = " + boardState.getScore(false));
+
+        // Print game state to terminal
+        System.out.println("\nPlacement String: " + boardState.getPlacementString());
+        // Update label text and disable grid, remove hint controls
+        disableGrid();
+        root.getChildren().removeAll(greenHint, greenHintLbl, redHint, redHintLbl);
+        playerTurn.setTextFill(Color.DEEPPINK);
+        playerTurn.setText("Game finished.");
+
+        // Show who has won the game and display scores
+        Score greenScore = new Score(boardState, Colour.Green);
+        Score redScore = new Score(boardState, Colour.Red);
+
+        String result = Score.getWinner(greenScore, redScore);
+        playerTurn.setText(result);
+        System.out.println(result);
+
+        /* Controls to set up new game if necessary */
+        Button playAgain = new Button("Play\nAgain");
+        playAgain.setId("control-btn");
+        playAgain.setPrefWidth(100);
+        playAgain.setOnAction(event -> {
+            resetGame();
+            System.out.println("\nNew game! " + greenState + " vs. " + redState);
+        });
+        Button menu = new Button("Menu");
+        menu.setId("control-btn");
+        menu.setPrefWidth(100);
+        menu.setOnAction(event -> {
+            primaryStage.close();
+        });
+        Button exit = new Button("Exit");
+        exit.setId("control-btn");
+        exit.setPrefWidth(100);
+        exit.setOnAction(event -> {
+            // Ask user if they want to exit the whole game
+            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
+                    "Do you really want to exit?", ButtonType.NO, ButtonType.YES);
+            Optional<ButtonType> response = confirm.showAndWait();
+            if (response.isPresent() && ButtonType.YES.equals(response.get())) System.exit(0);
+        });
+
+        VBox vBox = new VBox();
+        vBox.getChildren().addAll(playAgain, menu, exit);
+        vBox.setTranslateX((X_OFFSET - 100) / 2);
+        vBox.setTranslateY(BOARD_HEIGHT - 200);
+        vBox.setSpacing(20);
+
+        root.getChildren().addAll(vBox);
+        root.requestFocus();
+    }
+
+    // Start new game
+    private void resetGame() {
+        // Create new BoardState, reset hint count
+        boardState = new BoardState();
+        greenHintCount = hintCount;
+        redHintCount = hintCount;
+        // Setup UI and bots for new game
+        newGrid();
+        setupGame();
+        disableGrid();
+        botPlay();
+    }
+
+    // We create the default grid
+    private void newGrid() {
+        // Clear any existing children
+        root.getChildren().clear();
+        // Create grid with cell identifiers
+        for (int i = 0; i < GRID_SIZE; i++) { // columns
+            for (int j = 0; j < GRID_SIZE; j++) { // rows
+                // Build a new cell with the identifiers and add to root
+                char x = (char) (j + 'A');
+                char y = (char) (i + 'A');
+                addCell(x, y, null);
+            }
+        }
+        // Set the initial 'MMUA' piece
+        addCell('M', 'M', Colour.Red);
+        addCell('M', 'N', Colour.Green);
+    }
+
+    // Disable the grid at end of game or when bot is thinking to prevent clicks or hovering
+    private void disableGrid() {
+        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
+            root.getChildren().get(i).setDisable(true);
+    }
+    // Enable grid
+    private void enableGrid() {
+        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
+            root.getChildren().get(i).setDisable(false);
+    }
+
+    // Get the tile returned by the EasyBot and show it on the screen
+    private void showHint(Tile tile) {
+        char x = tile.getPosition().getCharX();
+        char y = tile.getPosition().getCharY();
+        switch (tile.getOrientation()) {
+            case A :
+                hintCell(x, y);
+                hintCell((char)(x+1), y);
+                hintCell(x, (char)(y+1));
+                break;
+            case B :
+                hintCell(x, y);
+                hintCell(x, (char)(y+1));
+                hintCell((char)(x-1), y);
+                break;
+            case C :
+                hintCell(x, y);
+                hintCell((char)(x-1), y);
+                hintCell(x, (char)(y-1));
+                break;
+            case D :
+                hintCell(x, y);
+                hintCell(x, (char)(y-1));
+                hintCell((char)(x+1), y);
+                break;
+        }
+        hintTile.setMouseTransparent(true);
+        root.getChildren().add(hintTile);
+    }
+
+    // Show a cell of a hint tile on the screen
+    private void hintCell(char x, char y) {
+        // Create new cell, change its properties and add to group
+        Cell cell = new Cell();
+        cell.setTranslateX(translateX(x));
+        cell.setTranslateY(translateY(y));
+        hintTile.getChildren().add(cell);
+    }
+
+    private void hoverTile(char x, char y) {
+        // Check end game state
+        if (boardState.getRedShapes().isEmpty()) {
+            endGame();
+            return;
+        }
+        // Get the shape we need to hover
+        Shape shape = (boardState.isGreenTurn()) ? boardState.getGreenShapes().getFirst()
+                : boardState.getRedShapes().getFirst();
+
+        // We don't want to show shape if it is out of bounds
+        switch (hoverOrientation) {
+            case A :
+                if (x == 'Z' || y == 'Z') return;
+                // Build the cells into the `hoverTile` Group
+                hoverCell(x, y, shape.colourAtIndex(0));
+                hoverCell((char)(x+1), y, shape.colourAtIndex(1));
+                hoverCell(x, (char)(y+1), shape.colourAtIndex(2));
+                break;
+            case B :
+                if (x == 'A' || y == 'Z') return;
+                // Build the cells into the `hoverTile` Group
+                hoverCell(x, y, shape.colourAtIndex(0));
+                hoverCell(x, (char)(y+1), shape.colourAtIndex(1));
+                hoverCell((char)(x-1), y, shape.colourAtIndex(2));
+                break;
+            case C :
+                if (x == 'A' || y == 'A') return;
+                // Build the cells into the `hoverTile` Group
+                hoverCell(x, y, shape.colourAtIndex(0));
+                hoverCell((char)(x-1), y, shape.colourAtIndex(1));
+                hoverCell(x, (char)(y-1), shape.colourAtIndex(2));
+                break;
+            case D :
+                if (x == 'Z' || y == 'A') return;
+                // Build the cells into the `hoverTile` Group
+                hoverCell(x, y, shape.colourAtIndex(0));
+                hoverCell(x, (char)(y-1), shape.colourAtIndex(1));
+                hoverCell((char)(x+1), y, shape.colourAtIndex(2));
+                break;
+        }
+        // Add the tile hover to the root node
+        hoverCurrentTile.setMouseTransparent(true);
+        root.getChildren().add(hoverCurrentTile);
+    }
+
+    private void hoverCell(char x, char y, Colour colour) {
+        // Create new cell, change its properties and add to group
+        Cell cell = new Cell(colour, boardState.isGreenTurn());
+        cell.setTranslateX(translateX(x));
+        cell.setTranslateY(translateY(y));
+        hoverCurrentTile.getChildren().add(cell);
+    }
+
+    private void addTile(char x, char y) {
+        // Create a new tile
+        Shape shape = (boardState.isGreenTurn()) ? boardState.getGreenShapes().getFirst()
+                : boardState.getRedShapes().getFirst();
+        Tile tile = new Tile(new Position(x, y), shape, hoverOrientation);
+        // Add a new tile to our board if it is valid
+        if (boardState.isTileValid(tile)) {
+            // Remove hint tile and add new tile to board
+            root.getChildren().remove(hintTile);
+            hintTile.getChildren().clear();
+            boardState.addTile(tile);
+        } else {
+            // When tile placement is not valid, we show an error message
+            playerTurn.setTextFill(Color.RED);
+            if (playerTurn.getText().contains("Invalid Tile Placement"))
+                playerTurn.setText(playerTurn.getText() + "!");
+            else playerTurn.setText("Invalid Tile Placement!");
+            return;
+        }
+
+        // Add cells onto the board based on the tile orientation
+        handleOrientation(tile);
+        previewTiles(boardState.isRedTurn());
+
+        // Reset preview orientation and check if bot is playing
+        hoverOrientation = Orientation.A;
+        botPlay();
+    }
+
+    // Add tile to board for bot, assume valid tile input
+    private void addTile(Tile tile) {
+        root.getChildren().remove(hintTile);
+        hintTile.getChildren().clear();
+        boardState.addTile(tile);
+
+        // Add cells onto the board based on the tile orientation
+        handleOrientation(tile);
+
+        // Preview next tiles and play game for bot
+        previewTiles(boardState.isRedTurn());
+        botPlay();
+    }
+
+    private void handleOrientation(Tile tile) {
+        // Add cells with their given colours given their orientation
+        char x = tile.getPosition().getCharX();
+        char y = tile.getPosition().getCharY();
+        Shape shape = tile.getShape();
+
+        switch (tile.getOrientation()) {
+            case A :
+                addCell(x, y, shape.colourAtIndex(0));
+                addCell((char)(x+1), y, shape.colourAtIndex(1));
+                addCell(x, (char)(y+1), shape.colourAtIndex(2));
+                break;
+            case B :
+                addCell(x, y, shape.colourAtIndex(0));
+                addCell(x, (char)(y+1), shape.colourAtIndex(1));
+                addCell((char)(x-1), y, shape.colourAtIndex(2));
+                break;
+            case C :
+                addCell(x, y, shape.colourAtIndex(0));
+                addCell((char)(x-1), y, shape.colourAtIndex(1));
+                addCell(x, (char)(y-1), shape.colourAtIndex(2));
+                break;
+            case D :
+                addCell(x, y, shape.colourAtIndex(0));
+                addCell(x, (char)(y-1), shape.colourAtIndex(1));
+                addCell((char)(x+1), y, shape.colourAtIndex(2));
+                break;
+        }
+
+        // Remove tiles from player pieces accordingly, recall player turn is inverted in BoardState
+        if (boardState.getPlayerTurn() == Colour.Red) boardState.getGreenShapes().removeFirst();
+        else boardState.getRedShapes().removeFirst();
+    }
+
+    private void addCell(char x, char y, Colour colour) {
+        // Creating a new cell
+        Cell cell;
+        // Handling grid identifier cells
+        if (colour == null) {
+            cell = new Cell("" + x + y);
+            cell.setTranslateX((x - 'A') * CELL_SIZE + X_OFFSET);
+            cell.setTranslateY((y - 'A') * CELL_SIZE + Y_OFFSET);
+            root.getChildren().add(cell);
+        } else {
+            // Create new cell, change its properties and add to root
+            if (boardState.getHeight(x, y) > 1)
+                cell = new Cell(colour, boardState.getHeight(x, y));
+            else
+                cell = new Cell(colour);
+            cell.setTranslateX(translateX(x));
+            cell.setTranslateY(translateY(y));
+            root.getChildren().set(getIndex(x, y), cell);
+        }
+
+        // Disable cursor over boadr
+        cell.setCursor(Cursor.NONE);
+
+        /* Add a tile to the board state and GUI grid */
+        cell.setOnMouseClicked(event -> {
+            addTile(x, y);
+        });
+        /* Show a slightly transparent tile on the GUI grid */
+        cell.setOnMouseEntered(event -> {
+            hoverTile(x, y);
+        });
+        /* Remove the preview tile on the GUI grid */
+        cell.setOnMouseExited(event -> {
+            root.getChildren().remove(hoverCurrentTile);
+            hoverCurrentTile.getChildren().clear();
+        });
+        /* Change the orientation of a preview tile on the GUI grid */
+        cell.setOnScroll(event -> {
+            // Remove the current tile preview and draw another one based on scroll direction
+            root.getChildren().remove(hoverCurrentTile);
+            hoverCurrentTile.getChildren().clear();
+            // Scroll down = clockwise, Scroll up = anti-clockwise
+            if (event.getDeltaY() < 0)
+                hoverOrientation = hoverOrientation.next();
+            else
+                hoverOrientation = hoverOrientation.previous();
+            hoverTile(x, y);
+        });
+    }
+
+    // Calculate how many pixels to translate x and y by on window
+    private int translateX(char x) { return (x - 'A') * CELL_SIZE + X_OFFSET; }
+    private int translateY(char y) { return (y - 'A') * CELL_SIZE + Y_OFFSET; }
+
+    /* We get the index in the Group `root`, of the position given */
+    private int getIndex(char x, char y) {
+        if (y - 'A' == 0) return x - 'A';
+        else return (x - 'A')+(y - 'A')*26;
+    }
+
+    private void botPlay() {
+        // Check if the current player is human or not, or if it is the end of the game and act accordingly
+        if (boardState.isGreenTurn() && greenState.isHuman() || boardState.isRedTurn() && redState.isHuman()) {
+            enableGrid();
+            return;
+        } else if (boardState.getRedShapes().isEmpty()) {
+            endGame();
+            return;
+        } else {
+            playerTurn.setText(playerTurn.getText() + ". Bot thinking...");
+            disableGrid();
+        }
+        // Delay the play of the bot so we can see placements as they occur, create a thread
+        Timer timer = new Timer();
+        timer.schedule(new TimerTask() {
+            @Override
+            public void run() {
+                Platform.runLater(() -> actualPlay());
+            }
+        }, 100);
+    }
+
+    // Let the bots play a move if it is their turn
+    private void actualPlay() {
+        // Check for which bot to initialise
+        if (boardState.isGreenTurn() && greenState == Player.EasyBot) {
+            EasyBot bot = new EasyBot(boardState, true);
+            addTile(bot.getMove());
+            return;
+        } else if (boardState.isGreenTurn() && greenState == Player.HardBot) {
+            HardBot bot = new HardBot(boardState, true, greenDifficulty);
+            addTile(bot.getMove());
+            return;
+        }
+
+        if (boardState.isRedTurn() && redState == Player.EasyBot) {
+            EasyBot bot = new EasyBot(boardState, false);
+            addTile(bot.getMove());
+        } else if (boardState.isRedTurn() && redState == Player.HardBot) {
+            HardBot bot = new HardBot(boardState, false, redDifficulty);
+            addTile(bot.getMove());
+        }
+    }
+
+    // Move Cursor bot from http://stackoverflow.com/questions/37500567/javafx-how-to-position-the-mouse
+    private void moveCursor(double x, double y) {
+        Platform.runLater(() -> {
+            try {
+                Robot robot = new Robot();
+                robot.mouseMove((int) x, (int) y);
+            } catch (AWTException e) {
+                System.out.println("Something went horribly wrong...");
+            }
+        });
+    }
+
+    Board(Stage parentStage, Player greenState, Player redState, double greenDifficulty, double redDifficulty, int hintCount) {
+        // Set player states and difficulty
+        this.greenState = greenState;
+        this.redState = redState;
+        this.greenDifficulty = (int)(greenDifficulty);
+        this.redDifficulty = (int)(redDifficulty);
+        this.hintCount = this.greenHintCount = this.redHintCount = hintCount;
+
+        // Prepare and show stage
+        primaryStage.setTitle("StratoGame");
+        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/G.png")));
+        primaryStage.setResizable(false);
+        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
+        primaryStage.setScene(scene);
 
-    // FIXME Task 8: Implement a basic playable Strato Game in JavaFX that only allows pieces to be placed in valid places
+        // Open as blocking dialog, so only one instance at a time
+        primaryStage.initModality(Modality.WINDOW_MODAL);
+        primaryStage.initOwner(parentStage);
 
-    // FIXME Task 9: Implement scoring
+        // Add CSS Stylesheet and add Open Sans for buttons
+        String style = getClass().getResource("assets/theme.css").toExternalForm();
+        scene.getStylesheets().add(style);
+        Font.loadFont(getClass().getResourceAsStream("assets/OpenSans-Regular.ttf"), 16);
 
-    // FIXME Task 11: Implement a game that can play valid moves (even if they are weak moves)
+        // Setup the game
+        newGrid();
+        setupGame();
+        disableGrid();
+        botPlay();
 
-    // FIXME Task 12: Implement a game that can play good moves
+        /* Let player's play with arrow keys. Player Green = WASD, Q and E to rotate and SPACE to place
+         * Player Red = IJKL, U and O to rotate and ENTER to place. */
+        scene.setOnKeyPressed(event -> {
+            // Consume and return if bot is thinking and human key press
+            if (boardState.isGreenTurn() && !greenState.isHuman()
+                    || boardState.isRedTurn() && !redState.isHuman()) {
+                event.consume();
+                return;
+            }
+            // Get which grid char-wise (x, y) the mouse pointer is currently at
+            Point p = MouseInfo.getPointerInfo().getLocation();
+            Point2D local = root.screenToLocal(p.getX(), p.getY());
+            char x = (char)((local.getX() - X_OFFSET)/CELL_SIZE + 'A');
+            char y = (char)((local.getY() - Y_OFFSET)/CELL_SIZE + 'A');
+            
+            /* Rotate clockwise for E or O key and anticlockwise for Q or I key
+             * W = up, A = left, S = down, D = right, CAPS LOCK = place tile
+             * I = up, J = left, K = down, L = right, ENTER = place tile
+             * We update the preview of the tile accordingly with the key movements */
+            if (event.getCode() == KeyCode.Q && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.U && boardState.isRedTurn()) {
+                root.getChildren().remove(hoverCurrentTile);
+                hoverCurrentTile.getChildren().clear();
+                hoverOrientation = hoverOrientation.previous();
+                hoverTile(x, y);
+            } else if (event.getCode() == KeyCode.E && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.O && boardState.isRedTurn()) {
+                root.getChildren().remove(hoverCurrentTile);
+                hoverCurrentTile.getChildren().clear();
+                hoverOrientation = hoverOrientation.next();
+                hoverTile(x, y);
+            } else if (event.getCode() == KeyCode.W && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.I && boardState.isRedTurn()) {
+                // Must be within the game grid
+                if (x >= 'A' && x <= 'Z' && y > 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, x, (char)(y-1)))
+                    moveCursor(p.getX(), p.getY() - CELL_SIZE);
+            } else if (event.getCode() == KeyCode.A && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.J && boardState.isRedTurn()) {
+                if (x > 'A' && x <= 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, (char)(x-1), y))
+                    moveCursor(p.getX() - CELL_SIZE, p.getY());
+            } else if (event.getCode() == KeyCode.S && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.K && boardState.isRedTurn()) {
+                if (x >= 'A' && x <= 'Z' && y >= 'A' && y < 'Z' && Position.isOnBoard(hoverOrientation, x, (char)(y+1)))
+                    moveCursor(p.getX(), p.getY() + CELL_SIZE);
+            } else if (event.getCode() == KeyCode.D && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.L && boardState.isRedTurn()) {
+                if (x >= 'A' && x < 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, (char)(x+1), y))
+                    moveCursor(p.getX() + CELL_SIZE, p.getY());
+            } else if (event.getCode() == KeyCode.SPACE && boardState.isGreenTurn()
+                    || event.getCode() == KeyCode.ENTER && boardState.isRedTurn()) {
+                if (x >= 'A' && x <= 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, x, y))
+                    addTile(x, y);
+            }
+        });
 
-    @Override
-    public void start(Stage primaryStage) throws Exception {
+        // As of now, we cannot terminate a Bot vs Bot game as it is constantly recursively called
+        primaryStage.setOnCloseRequest(event -> {
+            if (!redState.isHuman() && !greenState.isHuman() && !boardState.isFinished()) {
+                Alert message = new Alert(Alert.AlertType.ERROR, "Bot vs Bot game in progress."
+                        + " Please wait until the game is finished.");
+                message.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
+                message.showAndWait();
+                event.consume();
+            } else if (!boardState.isFinished()){
+                // If at least one player is human and the game isn't finished, gain user's confirmation
+                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
+                        "Game in progress. Do you really want to close?", ButtonType.NO, ButtonType.YES);
+                confirm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
+                Optional<ButtonType> response = confirm.showAndWait();
+                if (response.isPresent() && ButtonType.NO.equals(response.get())) event.consume();
+            } else {
+                // Game has finished here
+                primaryStage.close();
+            }
+        });
 
+        primaryStage.showAndWait();
     }
 }
Only in comp1140-ass2/src/comp1110/ass2/gui: Cell.java
Only in comp1140-ass2/src/comp1110/ass2/gui: Instructions.java
Only in comp1140-ass2/src/comp1110/ass2/gui: Menu.java
diff -ru -x .git ../master/comp1140-ass2/src/comp1110/ass2/gui/Viewer.java comp1140-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1140-ass2/src/comp1110/ass2/gui/Viewer.java	2016-10-15 13:59:26.000000000 +1100
+++ comp1140-ass2/src/comp1110/ass2/gui/Viewer.java	2016-10-15 14:04:03.000000000 +1100
@@ -1,79 +1,256 @@
 package comp1110.ass2.gui;
 
-import javafx.application.Application;
-import javafx.event.ActionEvent;
-import javafx.event.EventHandler;
+import comp1110.ass2.logic.Colour;
+import comp1110.ass2.logic.Orientation;
+import comp1110.ass2.logic.Shape;
+import javafx.geometry.Pos;
 import javafx.scene.Group;
 import javafx.scene.Scene;
+import javafx.scene.control.Alert;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
-import javafx.scene.layout.HBox;
+import javafx.scene.image.Image;
+import javafx.scene.input.KeyCode;
+import javafx.scene.layout.*;
+import javafx.stage.Modality;
 import javafx.stage.Stage;
+import comp1110.ass2.StratoGame;
+
+import java.util.Arrays;
 
 /**
- * A very simple viewer for piece placements in the link game.
+ * `Viewer` allows us to view piece placements in StratoGame
+ * given an input string
  *
- * NOTE: This class is separate from your main game class.  This
- * class does not play a game, it just illustrates various piece
- * placements.
+ * @author William Shen - u6096655
+ * @author Marvin Yang - u5894100
  */
-public class Viewer extends Application {
-
-    /* board layout */
-    private static final int VIEWER_WIDTH = 750;
-    private static final int VIEWER_HEIGHT = 700;
+class Viewer extends Stage {
+    /* Board Layout */
+    private static final int VIEWER_WIDTH = 675;
+    private static final int VIEWER_HEIGHT = 710;
+    private static final int GRID_SIZE = 26;
+    private static final int CELL_SIZE = 25;
+    private static final int TILE_PLACEMENT_LENGTH = 4;
 
-    private static final String URI_BASE = "assets/";
+    private static final int X_OFFSET = 15;
+    private static final int Y_OFFSET = 10;
 
+    // JavaFX Variables
     private final Group root = new Group();
     private final Group controls = new Group();
-    TextField textField;
+    private final Stage primaryStage = new Stage();
+    private TextField textField;
 
+    // Array to store heights
+    private int[][] heightArray = new int[GRID_SIZE][GRID_SIZE];
 
     /**
      * Draw a placement in the window, removing any previously drawn one
      *
-     * @param placement  A valid placement string
+     * @param placement A valid placement string
      */
-    void makePlacement(String placement) {
-        // FIXME Task 5: implement the simple placement viewer
+    private void makePlacement(String placement) {
+        // We clear an existing grid and set the initial tile "MMUA"
+        defaultGrid();
+        setInitialPiece();
+
+        // Clear the height array and set height for initial piece 'MMUA'
+        for (int i = 0; i < GRID_SIZE; i++)
+            Arrays.fill(heightArray[i], 0);
+        heightArray[12][12]++;
+        heightArray[12][13]++;
+
+        // We know if |placement| = 4, placement = "MMUA" only
+        if (placement.length() == 4) return;
+
+        // Loop through the rest of the placement string
+        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
+            // We get the X and Y coordinate of the origin, and create a Shape and Orientation object
+            char originX = placement.charAt(i);
+            char originY = placement.charAt(i + 1);
+            Shape shapeID = Shape.fromChar(placement.charAt(i + 2));
+            Orientation orientation = Orientation.fromChar(placement.charAt(i + 3));
+
+            // Update the height array with the new tile
+            updateHeightArray(originX, originY, orientation);
+
+            /* We set a cell on the board according to its orientation.
+               Recall that we represent a L-tile as a triple (a, b, c) encoded as:
+                     [a = 0]  [b = 1]
+                     [c = 2]
+               By using the methods in Colour, we can get the colour of a cell
+               within a tile at a given index.
+            */
+            switch (orientation) {
+                case A:
+                    setCell(originX, originY, shapeID.colourAtIndex(0));
+                    setCell((char) (originX + 1), originY, shapeID.colourAtIndex(1));
+                    setCell(originX, (char) (originY + 1), shapeID.colourAtIndex(2));
+                    break;
+                case B:
+                    setCell(originX, originY, shapeID.colourAtIndex(0));
+                    setCell(originX, (char) (originY + 1), shapeID.colourAtIndex(1));
+                    setCell((char) (originX - 1), originY, shapeID.colourAtIndex(2));
+                    break;
+                case C:
+                    setCell(originX, originY, shapeID.colourAtIndex(0));
+                    setCell((char) (originX - 1), originY, shapeID.colourAtIndex(1));
+                    setCell(originX, (char) (originY - 1), shapeID.colourAtIndex(2));
+                    break;
+                case D:
+                    setCell(originX, originY, shapeID.colourAtIndex(0));
+                    setCell(originX, (char) (originY - 1), shapeID.colourAtIndex(1));
+                    setCell((char) (originX + 1), originY, shapeID.colourAtIndex(2));
+                    break;
+            }
+        }
+    }
+
+    /* Set a cell on the board */
+    private void setCell(char x, char y, Colour colour) {
+        // Create a new Cell based on the given colour
+        Cell cell;
+        if (heightArray[x - 'A'][y - 'A'] > 1)
+            cell = new Cell(colour, heightArray[x - 'A'][y - 'A']);
+        else
+            cell = new Cell(colour);
+        // How much we translate the cell from (0,0)
+        cell.setTranslateX(translateX(x));
+        cell.setTranslateY(translateY(y));
+        // Add the Cell to the group and hence the Scene
+        root.getChildren().set(getIndex(x, y), cell);
+    }
+
+    /* Update the height array */
+    private void updateHeightArray(char c1, char c2, Orientation orientation) {
+        int x = c1 - 'A';
+        int y = c2 - 'A';
+        switch (orientation) {
+            case A:
+                heightArray[x][y]++;
+                heightArray[x + 1][y]++;
+                heightArray[x][y + 1]++;
+                return;
+            case B:
+                heightArray[x][y]++;
+                heightArray[x][y + 1]++;
+                heightArray[x - 1][y]++;
+                return;
+            case C:
+                heightArray[x][y]++;
+                heightArray[x - 1][y]++;
+                heightArray[x][y - 1]++;
+                return;
+            case D:
+                heightArray[x][y]++;
+                heightArray[x][y - 1]++;
+                heightArray[x + 1][y]++;
+        }
     }
 
+    /* We get the index in the Scene `root`, of the position given */
+    private int getIndex(char x, char y) {
+        if (y - 'A' == 0) return x - 'A';
+        else return (x - 'A')+(y - 'A')*GRID_SIZE;
+    }
+
+    // Calculate how many pixels to translate x and y by on window
+    private int translateX(char x) { return (x - 'A')* CELL_SIZE + X_OFFSET; }
+    private int translateY(char y) { return (y - 'A')* CELL_SIZE + Y_OFFSET; }
+
+    // Set the initial "MMUA" for ease
+    private void setInitialPiece() {
+        Cell c1 = new Cell(Colour.Red);
+        Cell c2 = new Cell(Colour.Green);
+        c1.setTranslateX(translateX('M'));
+        c1.setTranslateY(translateY('M'));
+        c2.setTranslateX(translateX('M'));
+        c2.setTranslateY(translateY('N'));
+        root.getChildren().set(getIndex('M', 'M'), c1);
+        root.getChildren().set(getIndex('M', 'N'), c2);
+    }
+
+    // We create the default grid
+    private void defaultGrid() {
+        // Clear any existing children
+        root.getChildren().clear();
+        // Create grid with cell identifiers
+        for (int i = 0; i < GRID_SIZE; i++) { // columns
+            for (int j = 0; j < GRID_SIZE; j++) { // rows
+                char x = (char) (j + 'A');
+                char y = (char) (i + 'A');
+                Cell cell = new Cell("" + x + y);
+                cell.setTranslateX(j * CELL_SIZE + X_OFFSET);
+                cell.setTranslateY(i * CELL_SIZE + Y_OFFSET);
+                root.getChildren().add(cell);
+            }
+        }
+        root.getChildren().add(controls);
+    }
 
     /**
      * Create a basic text field for input and a refresh button.
      */
     private void makeControls() {
+        Button menu = new Button("Close");
+        menu.setId("control-btn");
+        menu.setOnAction(event -> {
+            primaryStage.close();
+        });
+
         Label label1 = new Label("Placement:");
-        textField = new TextField ();
+
+        textField = new TextField();
         textField.setPrefWidth(300);
-        Button button = new Button("Refresh");
-        button.setOnAction(new EventHandler<ActionEvent>() {
-            @Override
-            public void handle(ActionEvent e) {
-                makePlacement(textField.getText());
-                textField.clear();
-            }
+        textField.setOnKeyPressed(event -> {
+            if (event.getCode().equals(KeyCode.ENTER)) handleRefresh();
         });
+
+        Button refresh = new Button("Refresh");
+        refresh.setOnAction(event -> {
+            handleRefresh();
+        });
+        // Add to HBox, layout and view
         HBox hb = new HBox();
-        hb.getChildren().addAll(label1, textField, button);
+        hb.getChildren().addAll(menu, label1, textField, refresh);
         hb.setSpacing(10);
-        hb.setLayoutX(130);
-        hb.setLayoutY(VIEWER_HEIGHT - 50);
+        hb.setPrefWidth(VIEWER_WIDTH);
+        hb.setAlignment(Pos.CENTER);
+        hb.setLayoutY(VIEWER_HEIGHT - 32);
         controls.getChildren().add(hb);
+        // Focus on text field
+        textField.requestFocus();
     }
 
-    @Override
-    public void start(Stage primaryStage) throws Exception {
-        primaryStage.setTitle("StratoGame Viewer");
-        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
-
-        root.getChildren().add(controls);
+    // Checks if the placement string is valid. If not, show popup dialog
+    private void handleRefresh() {
+        if (StratoGame.isPlacementValid(textField.getText())) {
+            makePlacement(textField.getText());
+            textField.clear();
+        } else {
+            defaultGrid();
+            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid placement string.");
+            alert.showAndWait();
+            textField.clear();
+        }
+    }
 
-        makeControls();
+    Viewer(Stage parentStage) {
+        primaryStage.setTitle("Viewer");
+        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/E.png")));
+        primaryStage.setResizable(false);
+
+        // Open as blocking dialog, so only one instance
+        primaryStage.initModality(Modality.WINDOW_MODAL);
+        primaryStage.initOwner(parentStage);
 
+        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
         primaryStage.setScene(scene);
-        primaryStage.show();
+
+        defaultGrid();
+        makeControls();
+        primaryStage.showAndWait();
     }
 }
Only in comp1140-ass2/src/comp1110/ass2/gui/assets: OpenSans-Bold.ttf
Only in comp1140-ass2/src/comp1110/ass2/gui/assets: OpenSans-Regular.ttf
Only in comp1140-ass2/src/comp1110/ass2/gui/assets: drums.wav
Only in comp1140-ass2/src/comp1110/ass2/gui/assets: theme.css
Only in comp1140-ass2/src/comp1110/ass2: logic
Only in comp1140-ass2/tests/comp1110/ass2: OrientationTest.java
Only in comp1140-ass2/tests/comp1110/ass2: ShapeTest.java
Only in comp1140-ass2/tests/comp1110/ass2: isOnBoardTest.java
Only in comp1140-ass2: uml-nofields.png
Only in comp1140-ass2: uml.png
```
## Test log
```
--javac output--
javac: file not found: comp1140-ass2/src/comp1140/ass2/*.java
Usage: javac <options> <source files>
use -help for a list of possible options
javac: file not found: comp1140-ass2/src/comp1140/ass2/gui/*.java
Usage: javac <options> <source files>
use -help for a list of possible options
----
java -cp comp1140-ass2/src:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/ass2-1140-tests.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore comp1140.ass2.TilePlacementWellFormedTest
---
JUnit version 4.12
.E
Time: 0.003
There was 1 failure:
1) initializationError(org.junit.runner.JUnitCommandLineParseResult)
java.lang.IllegalArgumentException: Could not find class [comp1140.ass2.TilePlacementWellFormedTest]
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:102)
	at org.junit.runner.JUnitCommandLineParseResult.parseArgs(JUnitCommandLineParseResult.java:50)
	at org.junit.runner.JUnitCommandLineParseResult.parse(JUnitCommandLineParseResult.java:44)
	at org.junit.runner.JUnitCore.runMain(JUnitCore.java:72)
	at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
Caused by: java.lang.ClassNotFoundException: comp1140.ass2.TilePlacementWellFormedTest
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.junit.internal.Classes.getClass(Classes.java:16)
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:100)
	... 4 more

FAILURES!!!
Tests run: 1,  Failures: 1

java -cp comp1140-ass2/src:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/ass2-1140-tests.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore comp1140.ass2.PlacementWellFormedTest
---
JUnit version 4.12
.E
Time: 0.008
There was 1 failure:
1) initializationError(org.junit.runner.JUnitCommandLineParseResult)
java.lang.IllegalArgumentException: Could not find class [comp1140.ass2.PlacementWellFormedTest]
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:102)
	at org.junit.runner.JUnitCommandLineParseResult.parseArgs(JUnitCommandLineParseResult.java:50)
	at org.junit.runner.JUnitCommandLineParseResult.parse(JUnitCommandLineParseResult.java:44)
	at org.junit.runner.JUnitCore.runMain(JUnitCore.java:72)
	at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
Caused by: java.lang.ClassNotFoundException: comp1140.ass2.PlacementWellFormedTest
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.junit.internal.Classes.getClass(Classes.java:16)
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:100)
	... 4 more

FAILURES!!!
Tests run: 1,  Failures: 1

java -cp comp1140-ass2/src:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/ass2-1140-tests.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore comp1140.ass2.PlacementValidTest
---
JUnit version 4.12
.E
Time: 0.006
There was 1 failure:
1) initializationError(org.junit.runner.JUnitCommandLineParseResult)
java.lang.IllegalArgumentException: Could not find class [comp1140.ass2.PlacementValidTest]
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:102)
	at org.junit.runner.JUnitCommandLineParseResult.parseArgs(JUnitCommandLineParseResult.java:50)
	at org.junit.runner.JUnitCommandLineParseResult.parse(JUnitCommandLineParseResult.java:44)
	at org.junit.runner.JUnitCore.runMain(JUnitCore.java:72)
	at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
Caused by: java.lang.ClassNotFoundException: comp1140.ass2.PlacementValidTest
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.junit.internal.Classes.getClass(Classes.java:16)
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:100)
	... 4 more

FAILURES!!!
Tests run: 1,  Failures: 1

java -cp comp1140-ass2/src:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/ass2-1140-tests.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore comp1140.ass2.ScoreFromPlacementTest
---
JUnit version 4.12
.E
Time: 0.003
There was 1 failure:
1) initializationError(org.junit.runner.JUnitCommandLineParseResult)
java.lang.IllegalArgumentException: Could not find class [comp1140.ass2.ScoreFromPlacementTest]
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:102)
	at org.junit.runner.JUnitCommandLineParseResult.parseArgs(JUnitCommandLineParseResult.java:50)
	at org.junit.runner.JUnitCommandLineParseResult.parse(JUnitCommandLineParseResult.java:44)
	at org.junit.runner.JUnitCore.runMain(JUnitCore.java:72)
	at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
Caused by: java.lang.ClassNotFoundException: comp1140.ass2.ScoreFromPlacementTest
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.junit.internal.Classes.getClass(Classes.java:16)
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:100)
	... 4 more

FAILURES!!!
Tests run: 1,  Failures: 1

java -cp comp1140-ass2/src:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/ass2-1140-tests.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/Users/benjamin/Uni/COMP1140/comp1110-tutors/bin/../ass2/junit-4.12.jar org.junit.runner.JUnitCore comp1140.ass2.GenerateMoveTest
---
JUnit version 4.12
.E
Time: 0.004
There was 1 failure:
1) initializationError(org.junit.runner.JUnitCommandLineParseResult)
java.lang.IllegalArgumentException: Could not find class [comp1140.ass2.GenerateMoveTest]
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:102)
	at org.junit.runner.JUnitCommandLineParseResult.parseArgs(JUnitCommandLineParseResult.java:50)
	at org.junit.runner.JUnitCommandLineParseResult.parse(JUnitCommandLineParseResult.java:44)
	at org.junit.runner.JUnitCore.runMain(JUnitCore.java:72)
	at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
Caused by: java.lang.ClassNotFoundException: comp1140.ass2.GenerateMoveTest
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.junit.internal.Classes.getClass(Classes.java:16)
	at org.junit.runner.JUnitCommandLineParseResult.parseParameters(JUnitCommandLineParseResult.java:100)
	... 4 more

FAILURES!!!
Tests run: 1,  Failures: 1

```
