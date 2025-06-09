





פרוייקט גמר בהנדסת תוכנה
חלופה – תכנון ותכנות מערכות בטלפונים ניידים תחת מערכת הפעלה Android



שם בית הספר: שער הנגב
שם האפליקציה/פרוייקט: Game Social
שם התלמיד: גיא ספיאלטר
ת.ז התלמיד: 217380146
שם המורה/מנחה: דביר הורביץ






תאריך לועזי של ההגשה: 12.6.2025                                                                                              
תשפ"ה
תוכן עניינים

תוכן עניינים	2
מבוא	4
מבנה/ארכיטקטורה	5
מימוש הפרוייקט	17
Activities	17
SplashScreenActivity	17
MainActivity	18
EditUserActivity	18
UserProfileActivity	22
EditGameActivity	23
SearchNavigationActivity	25
AbtMeActivity	27
פרגמנטים	28
LoginFragment	28
SignupFragment	28
GameRCFragment	30
UsersPageFragment	32
OtherUserProfileFragment	33
מחלקות עזר	34
GameAdapter	34
UserAdapter	35
טבלאות	36
User	36
Game	37
Follower	38
ממשקי דאו	39
UserDao	39
GameDao	40
FollowerDao	41
AppDatabase	42
Globals	43
מדריך למשתמש	45
רפלקציה אישית	48
ביבליוגרפיה	49
קוד	50
xml	50
activity_abt_me.xml	50
activity_edit_game.xml	54
activity_edit_user.xml	63
activity_main.xml	72
activity_navigation_drawer.xml	74
activity_splash_screen.xml	76
activity_users.xml	78
fragment_game_rc.xml	82
fragment_login.xml	84
fragment_other_user_profile.xml	88
fragment_signup	92
fragment_users_page	97
game_item	99
nav_header_layout	103
user_item	105
nav_menu.xml	110
ic_profile_placeholder.xml	111
ic_logout.xml	111
circle_background.xml	112
ic_about_me.xml	112
ic_add_gray.xml	113
ic_action_menu.xml	113
ic_launcher.xml	114
Database	115
AppDatabase	115
User	116
UserDao	117
UserAdapter	118
Game	124
GameDao	125
GameAdapter	126
Follower	130
FollowerDao	130
Fragment	133
GameRCFragment	133
LoginFragment	138
OtherUserProfileFragment	141
SignupFragment	143
UsersPageFragment	147
Activity	151
AbtMeActivity	151
EditGameActivity	152
EditUserActivity	159
MainActivity	171
SearchNavigationActivity	173
SplashScreenActivity	176
UserProfileActivity	178
Globals	182

מבוא 

כגיימר פעיל, נתקלתי שוב ושוב בבעיה של אוסף משחקים מבולגן – משחקים שקניתי ונשכחו, פלטפורמות מרובות שקשה לעקוב אחריהן, וחוסר במרחב אחד לשיתוף המלצות עם חברים. מהצורך הזה נולדה Game Social, אפליקציה שפותרת את הכאוס ומחברת בין ארגון לקהילה.
האפליקציה מאפשרת למשתמשים לנהל את כל המשחקים הדיגיטליים שלהם במקום אחד – מסטים ועד אפיק גיימס – עם אפשרות לסנן לפי ג'נר, התקדמות, או דירוג אישי. אבל זה לא נגמר שם: אפשר לשתף ביקורות, לעקוב אחרי מה החברים משחקים, והכל 100% מותאם אישית. 
‫כאשר‬‫ המשתמש‬ ‫נכנס‬ ‫לאפליקציה‬ ‫עליו‬ ‫להזדהות‬ ‫על‬ ‫ידי‬ ‫שם‬ ‫משתמש‬ ‫וסיסמא‪.‬‬ ‫אם‬ ‫הוא‬ ‫לא‬ ‫רשום‬ ‫למערכת‬‫‪,‬‬‫עליו‬ ‫ראשית‬ ‫ליצור‬ ‫משתמש‬ ‫עם‬ ‫פרטים‬ ‫אישיים‪.‬‬
‫בהרשמה‬‫ לא‬ ‫יהיה‬ ‫ניתן‬ ‫להירשם‬ ‫עם‬ ‫שם‬ ‫משתמש‬ ‫הקיים‬ ‫במערכת‬ ‫‪,‬‬ ‫הסיסמא‬ ‫חייבת‬ ‫לעמוד בתנאים ‬‫(‬‪8‬‬ ‫תווים‬ ‫ומעלה‬ ‫‪,‬‬ ‫מינימום‬ ‫אות‬ ‫גדולה‬ ‫‪,‬‬ ‫אות‬ ‫קטנה‬ ‫‪,‬‬ ‫ומספר)‬, לאחר הרשמה המשתמש נשלח לדף חדש שבוא הוא יכול להשלים את יצירת החשבון שלו (להוסיף תמונת פרופיל, מספר טלפון ותיאור שלו) ‫‪,‬‬ ‫בהתחברות‬ ‫הסיסמא‬ ‫והשם ‬‫חייבים‬ ‫להיות‬ ‫זהים‬ ‫לאלו‬ ‫השמורים‬ ‫במערכת‪.

לאחר שהמשתמש סיים את תהליך ההתחברות/הרשמה הוא נשלח לדף הפרופיל האישי שלו שבוא הוא יכול לראות את רשימת המשחקים שלו, להוסיף משחקים חדשים או לערוך משחקים קיימים ולחפש בהם.
דרך הדף הראשי המשתמש יכול לעבור לשלושה מסכים שונים: מסך משחק, מסך עריכת חשבון, ומסך התפריט.
בדף עריכת חשבון המשתמש יכול לערוך את הפרטים השונים של החשבון שלו; שם משתמש, סיסמה, מספר טלפון, תמונת פרופיל ותיאור.
במסך המשחק המשתמש יכול ליצור משחק חדש או לערוך משחק קיים מהספרייה שלו, כדי להוסיף משחק המשתמש צריך להכניס את הפרטים הבאים: שם משחק, ג'נר, אחוז הסיום של המשחק, דירוג ותיאור המשחק והחוויה שלו בזמן משחק.
פתיחת המסך תפריט תראה רשימה של כל החשבונות הקיים באפליקציה עם נתונים מקוצרים כמו מספר משחקים שיש לכל משתמש. לחיצה על חשבון תפתח את הדף פרופיל של החשבון הזה שעובד כמו הפרופיל האישי רק ללא האפשרויות עריכת משחק וחשבון.
בנוסף, דרך התפריט שקיים במסך המשתמש יוכל לחזור לפרופיל האישי שלו, להתנתק מהאפליקצייה ולגשת למסך 'על יוצר'.



‬‬

מבנה/ארכיטקטורה

תרשים זרימה










שם
תמונת מסך
MainActivity + LoginFragment

MainActivity + SignupFragment

EditUserActivity - view

EditUserActivity - editing

UserProfileActivity + GameRCFragment

EditGameActivity - saved

EditGameActivity - editing

SearchNavigationActivity + UsersPageFragment

SearchNavigationActivity - drawer open

SearchNavigationActivity + OtherUserProfileFragment

AbtMeActivity




מימוש הפרוייקט
Activities

SplashScreenActivity


שם המחלק
SlashScreenActivity
תפקיד המחלקה
 היא מחלקה האחראית על מסך הפתיחה של האפליקציה. תפקידה העיקרי הוא להציג אנימציית טעינה באמצעות ProgressBar ולבצע מעבר אוטומטי למסך כניסה (MainActivity) לאחר 2.5 שניות.



תכונה
סוג
תיאור / שימוש
pb
ProgressBar
רכיב ממשק משתמש המציין את התקדמות הפעולה.
countDownTimer
CountDownTimer
רכיב היוצר ספירה לאחור ומודיע כל זמן מסוים.




פעולה
תיאור פעולה
פרמטרים
new CountDownTimer(2500, 1)
‫פונקציה‬‫ זו‬ ‫אחראית‬ ‫על‬ ‫הפעלת‬ ‫טיימר‬ ‫של‬ ‫כ‬ ‫‪-‬‬2.5‬‬
‫שניות‬‫‪,‬‬ ‫בזמן‬ ‫הטיימר‬ ‫מתבצע‬ ‫אנימציה‬ ‫‪,‬‬
‫ובסיומה ‬‫מעבר‬ ‫למסך‬ ‫ההתחברות‪.‬‬
ללא



MainActivity

שם המחלקה
MainActivity
תפקיד המחלקה
מציגה את אפשרויות ההתחברות וההרשמה על ידי שימוש בפרגמנטים LoginFragment ו-SignupFragment



תכונה
סוג
תיאור / שימוש
‫‬‪‭fragmentContainerView‬‬
‫‬‪‭FragmentContainerView
‬‬‫‬‮מיכל‬ ‫עבור‬ ‫הפרגמנטים‬ ‫שמציגים‬ ‫את‬ מסכי ההתחברות והרשמה
loginFrag
LoginFragment
פרגמנט ההתחברות
signupFrag
SignupFragment
פרגמנט ההרשמה




פעולה
תיאור פעולה
פרמטרים
changeFragToLogin()
משנה את המסך להתחברות
ללא
changeFragToSignup()
משנה את המסך להרשמה
ללא

EditUserActivity

שם המחלקה
EditUserActivity
תפקיד המחלקה
לתת למשתמש לערוך את החשבון שלו



תכונה
סוג
תיאור / שימוש
appDatabase
AppDatabase
רכיב המאפשר יצירת גישה למעגר מידע של האפליקציה
userDao
UserDao
רכיב שדרכו אפשר לערוך ולקבל נתונים מהטבלת משתמשים
previewProfilePic
ImageView
רכיב תמונה אשר מראה את תמונת הפרופיל שלך
ונותן עריכה שלה
UsernameTxt
TextView
רכיב טקסט אשר מראה את השם משתמש שלך
PasswordTxt
TextView
רכיב טקסט אשר מראה את הסיסמה שלך
DescriptionTxt
TextView
רכיב טקסט אשר מראה את התיאור חשבון שלך
PhoneTxt
TextView
רכיב טקסט אשר מראה את המספר טלפון שלך
visibilityViews
ArrayList<View>
רשימה מכילה רכיבים לא משומשים בקוד שצריך לשנות את מצב הריאות שלהם
editUsername
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור שם משתמש חדש
editPassword
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור סיסמה חדשה
editPhone
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור מספר טלפון חדש
editDesc
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור תיאור חדש
editUser
Button
כפתור המאפשר עריכה של הערכי החשבון
saveEdits
Button
כפתור השומר את הערכים החדשים למאגר נתונים בתנאי שהם עומדים בכללים
exitbtn
Button
כפתור הפותח את מסך הפרופיל
requestPermissionLauncher
ActivityResultLauncher<String>
רכיב המבקש מהמשתמש הרשאות לצילום תמונות וגישה לגלרייה
pickImageLauncher
ActivityResultLauncher<String>
רכיב הפותח את הגלרייה ומקבל את התמונה שנבחרה
takePictureLauncher
ActivityResultLauncher<String>
רכיב שפותח את המצלמה ושומר את התמונה
delUser
FloatingActionButton
כפתור המתנתק מהאפליקציה ומוחק את המשתמש




פעולה
תיאור פעולה
פרמטרים
editUser.setOnClickListener
הקוד מאפשר מעבר למצב "עריכה" שבו המשתמש יכול לשנות את פרטי הפרופיל שלו, תוך הסתרת/הצגת הרכיבים הרלוונטיים בממשק.
new View.OnClickListener()
saveEdits.setOnClickListener
הקוד אוסף את הנתונים מהשדות, בודק את תקינותם, ומעדכן את פרטי המשתמש בבסיס הנתונים.לאחר מכן, הוא מסתיר את שדות העריכה ומחזיר את המסך למצב תצוגה רגיל,ומעדכן את הנתונים המוצגים למשתמש.
new View.OnClickListener()
previewProfilePic.setOnClickListener
כאשר המשתמש לוחץ על תמונת הפרופיל, מוצג דיאלוג עם שלוש אפשרויות: "צלם תמונה", "בחר מהגלריה" או "בטל". אם המשתמש בוחר "צלם תמונה", המערכת בודקת הרשאת מצלמה ומפעילה את אפליקציית המצלמה אם קיימת. אם בוחרים "בחר מהגלריה", נפתחת גלריית התמונות לבחירה. בחירה ב"בטל" סוגרת את הדיאלוג.
new View.OnClickListener()
validateUsernameInput
בודק את תקינות שדה שם המשתמש
String username
validatePasswordInput
בודק את תקינות הסיסמה
String password
refreshUserInfo
מעדכן את המידע המוצג למשתמש
ללא
copyImageToAppDir
שומר תמונה מהגלרייה לתקייה של האפליקציה
Uri contenturi
saveImageToInternalStorage
שומר תמונה שצולמה לתקייה של הפליקצייה בטלפון
Bitmap bitmap
dispatchTakePictureIntent
קורא למצלמה
ללא
delUser.setOnClickListener
מאתחל את הכפתור מחיקת חשבון
new View.OnClickListener()


UserProfileActivity

שם המחלקה
UserProfileActivity
תפקיד המחלקה
המסך מראה למשתמש את רשימת המשחקים שלו, נותנת לו להוסיף משחקים חדשים או לערוך משחקים קיימים ולחפש בהם.
דרך המסך המשתמש יכול לעבור לשלושה מסכים שונים: מסך משחק, מסך עריכת חשבון, ומסך התפריט.



תכונה
סוג
תיאור / שימוש
editUserBtn
ImageView
תמונת פרופיל אשר בלחיצה עליי פותחת את דף עריכת משתמש
curName
TextView
רכיב טקסט המראה את שם המשתמש
addgameFab
FloatingActionButton
כפתור המוביל לדף יצירת משחק
searchFab
FloatingActionButton
כפתור המוביל למסך התפריט
myGamesFrag
GameRCFragment
פרגמנט רשימת משחקים
fragmentManager
FragmentManager
מנהל פרגמנטים
followers
TextView
רכיב טקסט המראה את מספר המשתמשים שהמשתמש עוקב אחרי
following
TextView
רכיב טקסט המראה את מספר העוקבים של המשתמש




פעולה
תיאור פעולה
פרמטרים
addgameFab.setOnClickListener
פותח דף משחק עם פרמטרים ליצירת משחק חדש
new View.OnClickListener()
editUserBtn.setOnClickListener
פותח את דף עריכת חשבון
new View.OnClickListener()
searchFab.setOnClickListener
פותח את דף תפריט
new View.OnClickListener()

EditGameActivity

שם המחלקה
EditGameActivity
תפקיד המחלקה
לתת למשתמש ליצור ולערוך את המשחקים שלו


appDatabase
AppDatabase
רכיב המאפשר יצירת גישה למעגר מידע של האפליקציה
gameDao
GameDao
רכיב שדרכו אפשר לערוך ולקבל נתונים מהטבלת משחקים
curGame
Game
המשתנה משחק שעובדים עליו
NameTxt
TextView
רכיב טקסט אשר מראה את השם משחק
GenreTxt
TextView
רכיב טקסט אשר מראה את סוג משחק 
ReviewTxt
TextView
רכיב טקסט אשר מראה את התיאור משחק 
RatingTxt
TextView
רכיב טקסט אשר מראה את דירוג משחק 
StatusTxt
TextView
רכיב טקסט אשר מראה את התקדמות ההשלמה של המשחק
visibilityViews
ArrayList<View>
רשימה מכילה רכיבים לא משומשים בקוד שצריך לשנות את מצב הריאות שלהם
editName
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור שם משחק
editGenre
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור סוג משחק
editRating
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור דירוג
editReview
TextInputEditText
רכיב אשר מקבל טקסט כדי לבחור תיאור חדש
editStatus


רכיב אשר מקבל טקסט כדי לבחור את אחוז הסיום של המשחק
editInfo
Button
כפתור המאפשר עריכה של הערכי המשחק
saveEdits
Button
כפתור השומר את המשחק 
delGame
FloatingActionButton
כפתור שמוחק את המשחק וחוזר לפרופיל


פעולה
תיאור פעולה
פרמטרים
editGame.setOnClickListener
הקוד מאפשר מעבר למצב "עריכה" שבו המשתמש יכול לשנות את פרטי המשחק, תוך הסתרת/הצגת הרכיבים הרלוונטיים בממשק.
new View.OnClickListener()
saveEdits.setOnClickListener


הקוד אוסף את הנתונים מהשדות, בודק את תקינותם, ומעדכן את פרטי המשחק בבסיס הנתונים.לאחר מכן, הוא מסתיר את שדות העריכה ומחזיר את המסך למצב תצוגה רגיל,ומעדכן את הנתונים המוצגים למשתמש.
new View.OnClickListener()
refreshGameInfo
מעדכן את המידע המוצג למשתמש
ללא
delGame.setOnClickListener
מאתחל את הכפתור מחיקה
new View.OnClickListener()


SearchNavigationActivity

שם המחלקה
SearchNavigationActivity
תפקיד המחלקה
מסך ניווט ראשי עם תפריט באפליקציה. במסך מוצגים פרטי המשתמש הנוכחי, וניתן לנווט בין מסכים שונים דרך התפריט - כולל דף משתמשים, דף "אודות", וכפתור התנתקות.



תכונה
סוג
תיאור / שימוש
navView
NavigationView
רכיב תפריט
drawerLayout
DrawerLayout
רכיב מגירה שנמצע בתוך התפריט
materialToolbar
MaterialToolbar
סרגל עליון של האפליקציה
fragmentManager
FragmentManager
מנהל פרגמנטים
usersPageFragment
UsersPageFragment
פרגמנט רשימת משתמשים
headerView
View
כותרת התפריט
usernametxt
TextView
רכיב טקסט בכותרת תפריט המראה את שם המשתמש
navProfilebtn
ImageView
תמונת הפרופיל של המשתמש המשמשת גם ככפתור הפותח את הפרופיל האישי
closeDrawerBtn
ImageView
תמונה שסוגרת את התפריט




פעולה
תיאור פעולה
פרמטרים
navProfilebtn.setOnClickListener
פותח את הפרופיל האישי


new View.OnClickListener()
closeDrawerBtn.setOnClickListener
סוגר את התפריט
new View.OnClickListener()
materialToolbar.setNavigationOnClickListener
פותח את התפריט
new View.OnClickListener()
navView.setNavigationItemSelectedListener
*מגדיר את פעולות פריטי התפריט הצדדי. כאשר המשתמש לוחץ על אחת האפשרויות בתפריט, מתבצעת פעולה בהתאם לבחירה: בחירה ב"דף משתמשים" תטען פרגמנט של רשימת משתמשים, בחירה ב"אודות היוצר" תפתח מסך חדש עם פרטי האפליקציה, ולחיצה על "התנתק" תבצע התנתקות מהמערכת באמצעות הפונקציה logOut מהמחלקה Globals.
new NavigationView.OnNavigationItemSelectedListener()
switchFragToNewUserProfile
משנה את הפרגמנט לפרופיל של משתמש אחר (לא המחובר)
OtherUserProfileFragment 
switchFragToUserpage
משנה את הפרגמט לרשימת משתמשים
 ללא


	AbtMeActivity

שם המחלקה
AbtMeActivity
תפקיד המחלקה
מסך אודות המפתח



תכונה
סוג
תיאור / שימוש
wedoabitoftrolling
ImageView
תמונה נלחצת המובילה ליוטיוב




פעולה
תיאור פעולה
פרמטרים
wedoabitoftrolling.setOnClickListener
פותח סרטון ביוטיוב
new View.OnClickListener()



פרגמנטים

LoginFragment

שם המחלקה
LoginFragment
תפקיד המחלקה
פרגמנט התחברות לאפליקצייה



תכונה
סוג
תיאור / שימוש
appDatabase
AppDatabase
רכיב המאפשר יצירת גישה למעגר מידע של האפליקציה
usernameEditText
EditText
מקבל את שם המשתמש
passwordEditText
EditText
מקבל את הסיסמה
loginButton
Button
בודק את השם משתמש וסיסמה, אם הם נכונים עובר לפרופיל או לא מודיע שיש טעות
switchfrag
TextView
טקסט המשמש ככפתור מעבר לפרגמנט הרשמה




פעולה
תיאור פעולה
פרמטרים
loginButton.setOnClickListener
בודק את השם משתמש וסיסמה, אם הם נכונים עובר לפרופיל או לא מודיע שיש טעות
new View.OnClickListener()
switchfrag.setOnClickListener
עובר לפרגמנט הרשמה
new View.OnClickListener()

SignupFragment

שם המחלקה
SignupFragment
תפקיד המחלקה
פרגמנט הרשמה לאפליקצייה



תכונה
סוג
תיאור / שימוש
appDatabase
AppDatabase
רכיב המאפשר יצירת גישה למעגר מידע של האפליקציה
usernameEditText
EditText
מקבל את שם המשתמש
passwordEditText
EditText
מקבל את הסיסמה
confirmPasswordEditTxt
EditText
מקבל את האישור סיסמה
switchfrag
TextView
טקסט המשמש ככפתור מעבר לפרגמנט התחברות




פעולה
תיאור פעולה
פרמטרים
signupButton.setOnClickListener
מקבל את השם משתמש וסיסמה, בודק אם הם עומדים בתנאים, אם הם כן עובר למסך עריכת חשבון לסיים את היצירה של החשבון ואם לא מודיע שיש טעות
new View.OnClickListener()
validateInput
בודק שהשם משתמש וסיסמה עומדים בתנאי הרשמה
String username, String password, String confirmPassword
switchfrag.setOnClickListener
עובר לפרגמנט התחברות
new View.OnClickListener()


GameRCFragment

שם המחלקה
GameRCFragment
תפקיד המחלקה
פרגמט המראה רכיב רשימה נגללת של משחקים



תכונה
סוג
תיאור / שימוש
gameAdapter
GameAdapter
הרכיב היוצר ושולט ברשימה
gamesLiveData
MediatorLiveData<List<Game>>
רכיב הצופה ומגיב לשינוים ברשימת משחקים
currentGamesData
LiveData<List<Game>>
רשימת משחקים דינמית
dataBase
AppDatabase
רכיב המאפשר יצירת גישה למאגר מידע של האפליקציה
gameDao
GameDao
רכיב שדרכו אפשר לערוך ולקבל נתונים מהטבלת משחקים
gameRc
RecyclerView
הרכיב המראה את הרשימה
itemTouchHelper
IitemTouchHelper
עוזר השולט בפעולות של הרכיבים ברשימה
searchText
EditText
רכיב המשמש כבר חיפוש ברשימה
gamecount
TextView
רכיב טקסט המראה את מספר המשחקים שיש למשתמש
user
User
המשתמש אשר המשחקים שייכים לו




פעולה
תיאור פעולה
פרמטרים
searchText.addTextChangedListener
כאשר הטקסט בתא חיפוש משתנה הוא משנה את הרשימת משחקים לרשימה חדשה שמתאימה לחיפוש
new TextWatcher()
gamesLiveData.observe
כאשר יש שינוי ברשימת משחקים מודיע לadapter שהיא השתנתה ומבקש שיצור רכיבים מחדש שיתאימו לרשימה
getActivity(), new Observer<List<Game>>()
gamesLiveData.addSource
גורם לצופה (gamesLiveData) לצפות ברשימת משחקים 
(currentGamesData)
currentGamesData, new Observer<List<Game>>()
new GameAdapter
יוצר אדפטר של הרשימת משחקים
new ArrayList<>(), getActivity(), new GameAdapter.OnGameClickListener()
new GameAdapter.OnGameClickListener()
יוצר את הפעולה שיוצאת לפועל כשלוחצים על רכיב ברשימה. 
פותח את מסך משחק של המשחק שנלחץ ולפי למי הוא שייך אם אפשר לערוך אותו או לא
ללא


UsersPageFragment

שם המחלקה
UsersPageFragment
תפקיד המחלקה
פרגמט המראה רכיב רשימה נגללת של משתמשים



תכונה
סוג
תיאור / שימוש
userAdapter
UserAdapter
הרכיב היוצר ושולט ברשימה
usersLiveData
MediatorLiveData<List<User>>
רכיב הצופה ומגיב לשינוים ברשימת משתמשים
currentUsersData
LiveData<List<User>>
רשימת משתמשים דינמית
dataBase
AppDatabase
רכיב המאפשר יצירת גישה למאגר מידע של האפליקציה
userDao
UserDao
רכיב שדרכו אפשר לערוך ולקבל נתונים מהטבלת משתמשים
userRc
RecyclerView
הרכיב המראה את הרשימה
usercount
TextView
רכיב טקסט המראה את מספר המשתמשים הקיימים



פעולה
תיאור פעולה
פרמטרים
usersLiveData.observe
כאשר יש שינוי ברשימת משתמשים מודיע לadapter שהיא השתנתה ומבקש שיצור רכיבים מחדש שיתאימו לרשימה
getActivity(), new Observer<List<User>>()
usersLiveData.addSource
גורם לצופה (usersLiveData) לצפות ברשימת משתמשים 
(currentUsersData)
currentGamesData, new Observer<List<User>>()
new UserAdapter
יוצר אדפטר של הרשימת משתמשים
new ArrayList<>(), getActivity(), new UserAdapter.OnUserClickListener()
new UserAdapter.OnUserClickListener()
יוצר את הפעולה שיוצאת לפועל כשלוחצים על רכיב ברשימה. 
פותח את דף פרופיל של המשתמש שנלחץ 
ללא


OtherUserProfileFragment

שם המחלקה
OtherUserProfileFragment
תפקיד המחלקה
פרגמנט פרופיל של משתמש שהוא לא המשתמש המחובר



תכונה
סוג
תיאור / שימוש
userPfp
ImageView
רכיב תמונת פרופיל של המשתמש
curName
TextView
רכיב טקסט של שם המשתמש
exitFab
FloatingActionButton
כפתור חזרה אחורה
myGamesFrag
GameRCFragment
פרגמנט רשימת משחקים של המשתמש
user
User
המשתמש
followers
TextView
רכיב טקסט המראה את מספר המשתמשים שהמשתמש עוקב אחרי
following
TextView
רכיב טקסט המראה את מספר העוקבים של המשתמש




פעולה
תיאור פעולה
פרמטרים
displayUserProfile
מקבל את המשתמש ומציג את הנתונים שלו על המסך
User user
exitFab.setOnClickListener
מחליף את הפרגמנט פרופיל הפרגמנט רשימת משתמשים
new View.OnClickListener()


מחלקות עזר

GameAdapter

שם המחלקה
GameAdapter
תפקיד המחלקה
יצירה ושליטה ברכיבים של רשימות משחקים המוצגות בRecyclerView



תכונה
סוג
תיאור / שימוש
games
List<Game>
רשימת המשחקים
context
Context
המסך שעליו הרשימה תהיה מוצגת
onGameClickListener
OnGameClickListener
מאזין ללחיצות על הרכיבים של הרשימה




פעולה
תיאור פעולה
פרמטרים
GameAdapter
קונסטרקטור של המחלקה. שומר את הפרמטרים ויוצר פונקציות השוואה בין רשימה חדשה לישנה
List<Game> games, Context context, OnGameClickListener ouscl
onCreateViewHolder
יוצר רכיב חדש לרשימה, מכניס את הנתונים של המשחק המתאים לתוכו ומכניס אותו לRecyclerView
ViewGroup parent, int viewType
setGames
משנה את הרשימה
List<Game> games
onBindViewHolder
כשנוצר רכיב לרשימה מכניס את הנתונים של המשחק שלו לתוכו
GameViewHolder holder, int position
getItemCount
סופר את אורך של הרשימה
ללא


UserAdapter

שם המחלקה
UserAdapter
תפקיד המחלקה
יצירה ושליטה ברכיבים של רשימות משחקים המוצגות בRecyclerView



תכונה
סוג
תיאור / שימוש
users
List<User>
רשימת המשתמש
context
Context
המסך שעליו הרשימה תהיה מוצגת
onUserClickListener
OnUserClickListener
מאזין ללחיצות על הרכיבים של הרשימה




פעולה
תיאור פעולה
פרמטרים
UserAdapter
קונסטרקטור של המחלקה. שומר את הפרמטרים ויוצר פונקציות השוואה בין רשימה חדשה לישנה
List<User> users, Context context, OnUserClickListener ouscl
onCreateViewHolder
יוצר רכיב חדש לרשימה, מכניס את הנתונים של המשתמש המתאים לתוכו ומכניס אותו לRecyclerView
ViewGroup parent, int viewType
setUsers
משנה את הרשימה
List<User> Users
onBindViewHolder
כשנוצר רכיב לרשימה מכניס את הנתונים של המשתמש שלו לתוכו.
יוצר כפתור מעקב אחרי המשתמש.
אם המשתמש עוקב כבר יוצר כפתור הורדת עוקב.
UserViewHolder holder, int position
getItemCount
סופר את אורך של הרשימה
ללא
updateButtonStates
מעדכן את המצבים של הכפתורי מעקב והורדת מעקב 
לפי הצורך
User user, UserAdapter.UserViewHolder holder, boolean isFollowing, boolean isFollowed


טבלאות

User

שם המחלקה
User
תפקיד המחלקה
המחלקה User מייצגת טבלה בשם users בקוד java 



תכונה
סוג
תיאור / שימוש
id (userId)
int
‫‮מזהה‬ ‫ייחודי‬ ‫של‬
‫‬‮המשתמש‪,‬‬‫מיוצר‬
‫‬‮אוטומטית‬‫‬‮ על‬‫‬‮ ידי ‬‫‬‪‭Room ‬‬
‫‬‮בעת ‬‫הוספת‬ ‫המשתמש‬
‫‬‮לבסיס‬‫ הנתונים‪.‬‬
username
String
שם משתמש
 password
String
סיסמה
phonenumber
String
מספר טלפון
description
String
תיאור של המשתמש
pfpURI
String
uri של התמונת פרופיל




פעולה
תיאור פעולה
פרמטרים
User
‫‪Constructor, ‫בונה‬ ‫חדשות‬ ‫למחלקה‬‫‬‪‭ User‬‬‫‬‮עם ‬‫‬‮שם ‫‬‮המשתמש‬ ‫‬‮והסיסמה‬
‫‬‮כארגומנטים‪.‬‬‬‬
String username, String password


Game

שם המחלקה
Game
תפקיד המחלקה
המחלקה Game מייצגת טבלה בשם game בקוד java 



תכונה
סוג
תיאור / שימוש
id (gameId)
int
‫‮מזהה‬ ‫ייחודי‬ ‫של‬
המשחק ,‬‬‫מיוצר‬
‫‬‮אוטומטית‬‫‬‮ על‬‫‬‮ ידי ‬‫‬‪‭Room ‬‬
‫‬‮בעת ‬‫הוספה ‫‬‮לבסיס‬‫ הנתונים‪.‬‬
userId
int
מפתח זר מטבלת משתמשים
 name
String
שם המשחק
genre
String
סוג משחק
completion
int
אחוז סיום של המשחק
rating
int
דירוג המשחק
review
String
ביקורת




Follower

שם המחלקה
Follower
תפקיד המחלקה
המחלקה שומרת שני מתשנים של מספר משתמש



תכונה
סוג
תיאור / שימוש
followerId
int, primary key, foreignkey
שומר את המספר משתמש שעוקב אחרי המשתמש השני
followingId
int, primary key, foreignkey
שומר את המספר משתמש של המשתמש שעליו עוקבים




פעולה
תיאור פעולה
פרמטרים
Follower
קונסטרקטור, מקבל ושומר את המספרי משתמשים
int followerId, int followingId


ממשקי דאו

UserDao

שם המחלקה
UserDAO
תפקיד המחלקה
ממשק UserDao מגדיר את הפעולות שאפשר לבצע על טבלת המשתמשים



פעולה
תיאור פעולה
פרמטרים
מחזיר
insertUser
מכניס אוביקט משתמש לטבלה
User user
long
editUser
מעדכן אוביקט משתמש בטבלה
User user
ללא
delUser
מוחק אוביקט משתמש מהטבלה
User user
ללא
getUserByUsernameNPassword
שולף משתמש מהטבלה לפי השם משתמש והסיסמה שלו
String username, String password
User
getUserByUsername
שולף משתמש מהטבלה לפי השם משתמש שלו
String username
User
getUserByID
שולף משתמש מהטבלה לפי "המספר זהות" שלו
int id
User
countConnectedGamesToUserById
סופר משחקים שמחוברים למשתמש לפי המספר שלו
int id
int
countUsers
סופר את כל המשתמשים ברשימה
ללא
int
getAvgReviewFromAUser
מחשב את הדירוג הממוצע של המשחקים של המשתמש
int id
double
getUsersListByName
מקבל רשימה של משתמשים שמתאימים לחיפוש
String s
LiveData<List<User>>


GameDao

שם המחלקה
GameDao
תפקיד המחלקה
הממשק GameDAO מגדיר את הפעולות שאפשר לבצע על טבלת המשחקים



פעולה
תיאור פעולה
פרמטרים
מחזיר
insertGame
מכניס אוביקט משחק לטבלה
Game game
ללא
editGame
מעדכן אוביקט משחק בטבלה
Game game
ללא
delGame
מוחק אוביקט משחק מהטבלה
Game game
ללא
getGameByID
שולף משתמש מהטבלה לפי המספר שלו
int id
Game
getGamesForUserid
שולף משחקים המתאימים לחיפוש שמחוברים למשתמש 
int id, String name
LiveData<List<Game>>
countConnectedGamesToUserId
סופר משחקים שמחוברים למשתמש לפי המספר שלו
int id
int


FollowerDao

שם המחלקה
FollowerDao
תפקיד המחלקה
הממשק FollowerDAO מגדיר את הפעולות שאפשר לבצע על טבלת העוקבים



פעולה
תיאור פעולה
פרמטרים
מחזיר
insertGame
מכניס אוביקט עוקב לטבלה
Follower follower
ללא
editGame
מעדכן אוביקט עוקב בטבלה
Follower follower
ללא
delGame
מוחק אוביקט עוקב מהטבלה
Follower follower
ללא
countFollowers
סופר את המספר עוקבים שיש למשתמש
int id
int
countFollowing
סופר אחרי כמה משתמשים המשתמש עוקב
int id
int
getFollowItemByIds
מחזיר אובייקט עוקב על ידי שני המשתמשים
int followerUserId, int targetUserId
Follower


AppDatabase

שם המחלקה
AppDatabase
תפקיד המחלקה
המחלקה מנהלת את מאגר הנתונים של האפליקצייה ומקיימת חיבור בין הקוד בjava לטבלאות השונות דרך הממשקי DAO



תכונה
סוג
תיאור / שימוש
NUM_OF_THREADS
int
קובע את מספר הפעולות גישה האפשריות באותו הזמן
dtbWriteExecutor
ExecutorService
מנהל את הפעולות הניגשות לנתונים
INSTANCE
AppDatabase
המשתנה משמש ליישום תבנית "Singleton" עבור מסד הנתונים של האפליקציה, כדי להבטיח שהיה רק מופע אחד של מסד הנתונים בכל האפליקציה 
והגישה תהיה בטוחה לשימוש מכמה Threads בו-זמנית




פעולה
תיאור פעולה
פרמטרים
userDao()
מחזיר את הממשק DAO של הטבלה USERS
ללא
gameDao()
מחזיר את הממשק DAO של הטבלה GAMES
ללא
FollowerDao()
מחזיר את הממשק DAO של הטבלה FOLLOWERS
ללא
getDatabase
מחזיר את המסד נתונים אם אחד קיים או יוצר אחד אם לא
Context context



Globals


שם המחלקה
Globals
תפקיד המחלקה
לשמור על משתנים חשובים שצריך לגשת אליהם מכל האפליקציה



תכונה
סוג
תיאור / שימוש
DEST_ID
final String
קבוע שאומר לפרגמנטים או מסכים על איזה ID הם אמורים להפתח
ITEM_EDITABLE
final String
קבוע שאומר לפרגמנטים או מסכים אם מותר להם לערוך את מה שהם פותחים
curUser
User
המשתמש המחובר




פעולה
תיאור פעולה
פרמטרים
getCurUser
מחזיר את החשבון המחובר כדי שיהיה אפשרות לעשות עליו פעולות בצורה בטוחה
ללא






logOut
מתנתק מהחשבון, סוגר את כל המסכים הפתוחים ושולח למסך כניסה
Activity context





שם המחלקה


תפקיד המחלקה





תכונה
סוג
תיאור / שימוש
















פעולה
תיאור פעולה
פרמטרים












מדריך למשתמש

דרישות והתקנה  
האפליקציה פותחה ב-Android Studio ומתאימה למכשירי אנדרואיד בגרסה 7.0 (Nougat) ומעלה.  
- API מינימלי: 24 (Android 7.0).  
- סביבת בדיקה: האפליקציה נוסתה על אמולטור (Medium Phone API 35) ועל מכשיר פיזי (Samsung Galaxy A53, Android 14).  
- הרשאות נדרשות:  
  - גישה למצלמה (לצילום תמונת פרופיל).  
  - גישה לאחסון הפנימי (לשמירת תמונות).  

 תיאור כללי  
Game Social מאפשרת לכם לנהל פרופיל אישי, להוסיף משחקים שביצעתם, לדרג אותם, ולצפות במשחקים של משתמשים אחרים.  

 ניווט בסיסי  
1. מסך ראשי:  
   - התחברות (Login): הכניסה לפרופיל הקיים.  
   - הרשמה (Signup): יצירת פרופיל חדש.  
2. מסך פרופיל אישי:  
   - לחיצה על תמונת הפרופיל מעבר לעריכה.  
   - לחיצה על + (Floating Button) להוספת משחק חדש.  
   - לחיצה על 🔍 (Floating Button) מעבר לחיפוש משתמשים.  
3. מסך חיפוש:  
   - חיפוש משתמשים או משחקים באמצעות סרגל החיפוש.  
   - לחיצה על משתמש מעבר לפרופיל שלו.  

 הודעות למשתמש  
- Toast (הודעות קצרות בתחתית המסך):  
  - בהרשמה/התחברות: "שם משתמש או סיסמה לא תקינים", "הסיסמה חייבת לכלול אות גדולה ומספר".  
  - בעריכת פרופיל: "תמונה נשמרה בהצלחה", "שם משתמש כבר תפוס".  
  - בהוספת משחק: "נא למלא את כל השדות", "דירוג חייב להיות בין 1-10".  

- Alert Dialog (חלון התראה):  
  - בעת מחיקת משחק: "האם אתה בטוח שברצונך למחוק את המשחק?".
- בעת מחיקת חשבון: "האם אתה בטוח שברצונך למחוק את החשבון?"  

 מגבלות ואילוצים  
1. פרופיל אישי:  
   - שם משתמש:  
     - מינימום 3 תווים.  
     - אסור שיכיל מספרים.  
   - סיסמה:  
     - מינימום 8 תווים.  
     - חייבת לכלול לפחות אות גדולה אחת ומספר אחד.  
   - תמונת פרופיל:  
     - גודל מקסימלי: 5MB.  
     - פורמטים נתמכים: JPEG, PNG.  

2. משחק:  
   - שדות חובה: שם, ז'אנר, דירוג , אחוז השלמה, ביקורת.  
   - דירוג: חייב להיות מספר בין 1 ל-10.  
   - אחוז השלמה: חייב להיות בין 0 ל-100.  

 הוראות שימוש מפורטות  
 1. יצירת פרופיל והתחברות  
- הרשמה:  
 	 1. מלאו את הטופס עם הפרטים הדרושים.  
  2. אם יש שגיאה, תופיע הודעת Toast עם הסבר (למשל: "סיסמה חלשה מדי").  
  3. לאחר ההרשמה, תועברו אוטומטית למסך עריכת פרופיל להוספת תמונה ופרטים נוספים.  

- התחברות:  
  	1. הזינו את שם המשתמש והסיסמה.  
 	 2. אם הפרטים שגויים, תופיע הודעת Toast: "פרטים לא תקינים".  

 2. ניהול משחקים  
- הוספת משחק:  
 	 1. במסך הפרופיל, לחצו על +.  
 	 2. מלאו את הפרטים ולחצו Save.  
  	3. אם שדה חסר, תופיע הודעת Toast עם השדה החסר.  

- מחיקת משחק:  
  1. החלקו את המשחק שמאלה ← (←) ברשימה, או במסך עריכת משחק לחצו על הכפתור פח.
  2. יופיע Alert Dialog לאישור המחיקה.  

 3. גלישה בין משתמשים  
- חיפוש:  
  1. הקלידו שם במנוע החיפוש.  
  2. תוצאות יופיעו בזמן אמת.  
  3. לחצו על משתמש כדי לראות את הפרופיל והמשחקים שלו.  


















רפלקציה אישית

כשהתחלתי את הפרוייקט, היו לי חלומות גדולים. רציתי ליצור אפליקציה של ספרית משחקים שיתופית שתאפשר למשתמשים לנהל את אוסף המשחקים שלהם, לשתף ביקורות והמלצות עם חברים, ולגלות משחקים חדשים דרך הקהילה. אם להיות כנה עם עצמי, לא הצלחתי להשיג את כל מה שתכננתי. בסופו של דבר, הצלחתי לפתח גרסה בסיסית של האפליקציה. זה לא היה מה שחלמתי עליו בהתחלה, אבל זה עובד וזה משהו שאני יכול להיות גאה בו.
הקושי הכי גדול שלי היה ניהול הזמן. בבית היה לי קשה מאוד להתרכז בעבודה על הפרוייקט. תמיד היו הסחות דעת. גיליתי שאני אדם שזקוק למבנה וללחץ חיצוני כדי להיות יעיל.
בנוסף, גיליתי שהתכנות המתקדם שרציתי לעשות דרש יותר זמן ומיומנות ממה שהערכתי. היו רגעים של תסכול כשקוד לא עבד והרגשתי שאני לא מתקדם.
למרות הקשיים, היו גם רגעים מדהימים. כשהצלחתי לגרום לפיצ'ר הראשון לעבוד - להוסיף משחק למסד הנתונים ולראות אותו מופיע ברשימה - זה היה הרגע שבו הבנתי למה אני אוהב תכנות.
התגברתי על הקשיים שלי על ידי שחילקתי את הפרוייקט למטלות קטנות יותר. במקום לחשוב על כל האפליקציה, התרכזתי במטלה אחת בכל פעם - קודם ממשק משתמש, אחר כך מסד נתונים, וכן הלאה.
למדתי על עצמי שאני צריך משהו חיצוני כדי להיות יעיל. בבית אני מתקשה להתרכז, אבל בסביבה מובנית אני יכול להשיג דברים מדהימים. למדתי גם שחשוב להיות ריאלי עם הציפיות שלי. יש הבדל בין לחלום בגדול לבין לתכנן בצורה מעשית. 
האנשים שעזרו לי הם המורה שלי למגמה והחברים בכיתה. כשנתקעתי בבעיות קוד, תמיד היה מישהו שיכול להסביר או לעזור לחשוב על הבעיה מזווית אחרת.
להמשך הבנתי שאני צריך ללמוד לנהל את הזמן שלי נכון ולא לסמוך רק על המוטיבציה שלי, לחלק את הפרוייקט הגדול למשימות קטנות יותר ולתכנן יותר טוב. הבנתי שאני יכול ליצור דברים מעניינים, אבל אני צריך ללמוד איך לנהל את עצמי טוב יותר.
הכי חשוב - הבנתי שזה בסדר שהפרוייקט לא יצא מושלם. מה שחשוב זה שלמדתי, התקדמתי, ויש לי משהו שעובד בסוף.
ביבליוגרפיה

Geeks for geeks: https://www.geeksforgeeks.org/
 Stack overflow: https://stackoverflow.com/
 android studio: https://developer.android.com/reference
המדריכים המדהימים של דביר



























קוד
 xml

activity_abt_me.xml

<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    android:background="@color/white"
    tools:context=".AbtMeActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="24dp">

        <ImageView
            android:id="@+id/profile_image"
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:layout_marginTop="24dp"
            android:contentDescription="@string/profile_image_desc"
            android:scaleType="centerCrop"
            android:src="@drawable/ic_profile_placeholder"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:background="@drawable/circle_background"
            android:padding="4dp"/>

        <!-- Name -->
        <TextView
            android:id="@+id/name_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="@string/creator_name"
            android:textColor="@color/black"
            android:textSize="24sp"
            android:textStyle="bold"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/profile_image" />

        <TextView
            android:id="@+id/section_bio"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="82dp"
            android:text="@string/bio_section"
            android:textColor="@color/black"
            android:textSize="18sp"
            android:textStyle="bold"
            app:layout_constraintEnd_toEndOf="@+id/name_text"
            app:layout_constraintStart_toStartOf="@+id/name_text"
            app:layout_constraintTop_toBottomOf="@+id/name_text" />

        <TextView
            android:id="@+id/bio_text"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="A lot of bullshit about me"
            android:textColor="@color/gray_700"
            android:textSize="16sp"
            app:layout_constraintEnd_toEndOf="@+id/section_bio"
            app:layout_constraintStart_toStartOf="@+id/section_bio"
            app:layout_constraintTop_toBottomOf="@id/section_bio" />

        <TextView
            android:id="@+id/section_contact"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="24dp"
            android:text="@string/contact_section"
            android:textColor="@color/black"
            android:textSize="18sp"
            android:textStyle="bold"
            app:layout_constraintEnd_toEndOf="@+id/section_bio"
            app:layout_constraintStart_toStartOf="@+id/section_bio"
            app:layout_constraintTop_toBottomOf="@id/bio_text" />

        <LinearLayout
            android:id="@+id/linearLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:gravity="center_vertical"
            android:orientation="horizontal"
            app:layout_constraintEnd_toEndOf="@+id/section_bio"
            app:layout_constraintStart_toStartOf="@+id/section_bio"
            app:layout_constraintTop_toBottomOf="@id/section_contact">

            <ImageView
                android:layout_width="24dp"
                android:layout_height="24dp"
                android:layout_marginEnd="12dp"
                android:src="@android:drawable/ic_dialog_email"
                app:tint="@color/primary" />

            <TextView
                android:id="@+id/email_text"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/creator_email"
                android:textColor="@color/gray_700"
                android:textSize="16sp" />
        </LinearLayout>

        <ImageView
            android:id="@+id/imageView4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="8dp"
            android:clickable="true"
            app:layout_constraintBottom_toBottomOf="@+id/name_text"
            app:layout_constraintEnd_toStartOf="@+id/name_text"
            app:layout_constraintTop_toTopOf="@+id/name_text"
            app:srcCompat="@android:drawable/ic_dialog_info" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</ScrollView>
activity_edit_game.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/editGame"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".EditUserActivity">

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/deleteGameFAB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:elevation="12dp"
        android:src="@android:drawable/ic_menu_delete"
        app:backgroundTint="@android:color/system_error_light"
        app:fabCustomSize="44dp"
        app:fabSize="mini"
        app:layout_constraintBottom_toTopOf="@+id/editGameinfoBtn"
        app:layout_constraintEnd_toEndOf="@+id/editGameinfoBtn"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintStart_toStartOf="@+id/editGameinfoBtn"
        app:maxImageSize="28dp" />

    <TextView
        android:id="@+id/gameNameTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginBottom="24dp"
        android:text="Name:"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0" />

    <TextView
        android:id="@+id/gameNameView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/gameNameTextView"
        app:layout_constraintStart_toEndOf="@+id/gameNameTextView"
        app:layout_constraintTop_toTopOf="@+id/gameNameTextView" />

    <TextView
        android:id="@+id/gameGenreTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:text="Genre:"
        app:layout_constraintEnd_toEndOf="@+id/gameNameTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/gameNameTextView"
        app:layout_constraintTop_toBottomOf="@+id/gameNameTextView" />

    <TextView
        android:id="@+id/gameGenreView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/gameGenreTextView"
        app:layout_constraintStart_toEndOf="@+id/gameGenreTextView"
        app:layout_constraintTop_toTopOf="@+id/gameGenreTextView" />

    <TextView
        android:id="@+id/gameRatingTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:text="Rating:"
        app:layout_constraintEnd_toEndOf="@+id/gameGenreTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/gameGenreTextView"
        app:layout_constraintTop_toBottomOf="@+id/gameGenreTextView" />

    <TextView
        android:id="@+id/gameReviewTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:gravity="fill"
        android:text="Review:"
        app:layout_constraintEnd_toEndOf="@+id/gameStatusTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/gameStatusTextView"
        app:layout_constraintTop_toBottomOf="@+id/gameStatusTextView" />

    <TextView
        android:id="@+id/gameReviewView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:ellipsize="end"
        android:maxEms="25"
        app:layout_constraintBottom_toBottomOf="@+id/gameReviewTextView"
        app:layout_constraintEnd_toEndOf="@+id/gtextInputLayout4"
        app:layout_constraintStart_toEndOf="@+id/gameReviewTextView"
        app:layout_constraintTop_toTopOf="@+id/gameReviewTextView" />

    <TextView
        android:id="@+id/gameStatusTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:text="Completion status:"
        app:layout_constraintEnd_toEndOf="@+id/gameRatingTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/gameRatingTextView"
        app:layout_constraintTop_toBottomOf="@+id/gameRatingTextView" />

    <TextView
        android:id="@+id/gameStatusView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/gameStatusTextView"
        app:layout_constraintStart_toEndOf="@+id/gameStatusTextView"
        app:layout_constraintTop_toTopOf="@+id/gameStatusTextView"
        tools:text="100" />

    <TextView
        android:id="@+id/gameRatingView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/gameRatingTextView"
        app:layout_constraintStart_toEndOf="@+id/gameRatingTextView"
        app:layout_constraintTop_toTopOf="@+id/gameRatingTextView"
        tools:text="10" />

    <Button
        android:id="@+id/editGameinfoBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginBottom="24dp"
        android:text="Edit Info"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />

    <Button
        android:id="@+id/saveGameEditsBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Save"
        android:visibility="invisible"
        app:layout_constraintBottom_toBottomOf="@+id/editGameinfoBtn"
        app:layout_constraintEnd_toEndOf="@+id/editGameinfoBtn"
        app:layout_constraintStart_toStartOf="@+id/editGameinfoBtn"
        app:layout_constraintTop_toTopOf="@+id/editGameinfoBtn" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gtextInputLayout"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:layout_marginEnd="16dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/gameGenreTextView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/gameNameTextView"
        app:layout_constraintTop_toBottomOf="@+id/gameNameTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newNameText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="text|textPersonName"
            android:maxLength="20"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gtextInputLayout2"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/gameRatingTextView"
        app:layout_constraintEnd_toEndOf="@+id/gtextInputLayout"
        app:layout_constraintStart_toStartOf="@+id/gtextInputLayout"
        app:layout_constraintTop_toBottomOf="@+id/gameGenreTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newGenreText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="text|textPersonName"
            android:maxLength="10"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gtextInputLayout3"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/gameReviewTextView"
        app:layout_constraintEnd_toEndOf="@+id/gtextInputLayout2"
        app:layout_constraintStart_toStartOf="@+id/gtextInputLayout2"
        app:layout_constraintTop_toBottomOf="@+id/gameStatusTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newStatusText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:maxLength="3"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gtextInputLayout4"
        android:layout_width="250dp"
        android:layout_height="180dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="@+id/gtextInputLayout3"
        app:layout_constraintStart_toStartOf="@+id/gtextInputLayout3"
        app:layout_constraintTop_toBottomOf="@+id/gameReviewTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newReviewText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="text|textLongMessage|textMultiLine"
            android:maxEms="25"
            android:singleLine="false" />
    </com.google.android.material.textfield.TextInputLayout>

    <TextView
        android:id="@+id/warningTextg"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="if u dont want to change something,\n leave the field empty"
        android:textColor="@color/design_default_color_error"
        android:visibility="invisible"
        app:layout_constraintBottom_toBottomOf="@+id/editGameinfoBtn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editGameinfoBtn"
        app:layout_constraintTop_toTopOf="@+id/editGameinfoBtn" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="/10"
        app:layout_constraintBottom_toBottomOf="@+id/gameRatingView"
        app:layout_constraintStart_toEndOf="@+id/gameRatingView"
        app:layout_constraintTop_toTopOf="@+id/gameRatingView" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gtextInputLayout5"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/gameStatusTextView"
        app:layout_constraintEnd_toEndOf="@+id/gtextInputLayout"
        app:layout_constraintStart_toStartOf="@+id/gtextInputLayout"
        app:layout_constraintTop_toBottomOf="@+id/gameRatingTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newRatingText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:maxLength="2"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="%"
        app:layout_constraintBottom_toBottomOf="@+id/gameStatusView"
        app:layout_constraintStart_toEndOf="@+id/gameStatusView"
        app:layout_constraintTop_toTopOf="@+id/gameStatusView" />

</androidx.constraintlayout.widget.ConstraintLayout>
activity_edit_user.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/editUser"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".EditUserActivity">

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/deleteUserFAB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:elevation="12dp"
        android:src="@android:drawable/ic_menu_delete"
        app:backgroundTint="@android:color/holo_red_dark"
        app:fabCustomSize="44dp"
        app:fabSize="mini"
        app:layout_constraintBottom_toTopOf="@+id/editUserinfoBtn"
        app:layout_constraintEnd_toEndOf="@+id/editUserinfoBtn"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintStart_toStartOf="@+id/editUserinfoBtn"
        app:maxImageSize="28dp" />

    <com.google.android.material.imageview.ShapeableImageView
        android:id="@+id/profilePreview"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:focusable="true"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toEndOf="@+id/myProfilePicTextView"
        app:layout_constraintTop_toTopOf="@+id/myProfilePicTextView"
        app:srcCompat="@android:drawable/ic_menu_upload" />

    <TextView
        android:id="@+id/myUsernameTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginBottom="24dp"
        android:text="Username:"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0" />

    <TextView
        android:id="@+id/myUsernameView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/myUsernameTextView"
        app:layout_constraintStart_toEndOf="@+id/myUsernameTextView"
        app:layout_constraintTop_toTopOf="@+id/myUsernameTextView" />

    <TextView
        android:id="@+id/myPasswordTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:text="Password:"
        app:layout_constraintEnd_toEndOf="@+id/myUsernameTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/myUsernameTextView"
        app:layout_constraintTop_toBottomOf="@+id/myUsernameTextView" />

    <TextView
        android:id="@+id/myPasswordView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/myPasswordTextView"
        app:layout_constraintStart_toEndOf="@+id/myPasswordTextView"
        app:layout_constraintTop_toTopOf="@+id/myPasswordTextView" />

    <TextView
        android:id="@+id/myProfilePicTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:text="Profile Picture"
        app:layout_constraintEnd_toEndOf="@+id/myPasswordTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/myPasswordTextView"
        app:layout_constraintTop_toBottomOf="@+id/myPasswordTextView" />

    <TextView
        android:id="@+id/myBioTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        android:gravity="fill"
        android:text="User description: "
        app:layout_constraintEnd_toEndOf="@+id/myPhoneTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/myPhoneTextView"
        app:layout_constraintTop_toBottomOf="@+id/myPhoneTextView" />

    <TextView
        android:id="@+id/myBioView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:ellipsize="end"
        app:layout_constraintBottom_toBottomOf="@+id/myBioTextView"
        app:layout_constraintEnd_toEndOf="@+id/textInputLayout4"
        app:layout_constraintStart_toEndOf="@+id/myBioTextView"
        app:layout_constraintTop_toTopOf="@+id/myBioTextView"
        app:layout_constraintVertical_bias="0.0" />

    <TextView
        android:id="@+id/myPhoneTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="Phone number:"
        app:layout_constraintEnd_toEndOf="@+id/myProfilePicTextView"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/myProfilePicTextView"
        app:layout_constraintTop_toBottomOf="@+id/profilePreview" />

    <TextView
        android:id="@+id/myPhoneView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        app:layout_constraintBottom_toBottomOf="@+id/myPhoneTextView"
        app:layout_constraintStart_toEndOf="@+id/myPhoneTextView"
        app:layout_constraintTop_toTopOf="@+id/myPhoneTextView" />

    <Button
        android:id="@+id/editUserinfoBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginBottom="24dp"
        android:text="Edit User"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />

    <Button
        android:id="@+id/saveEditsBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Save"
        android:visibility="invisible"
        app:layout_constraintBottom_toBottomOf="@+id/editUserinfoBtn"
        app:layout_constraintEnd_toEndOf="@+id/editUserinfoBtn"
        app:layout_constraintStart_toStartOf="@+id/editUserinfoBtn"
        app:layout_constraintTop_toTopOf="@+id/editUserinfoBtn" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:layout_marginEnd="16dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/myPasswordTextView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/myUsernameTextView"
        app:layout_constraintTop_toBottomOf="@+id/myUsernameTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newUsernameText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="New username"
            android:inputType="text|textPersonName"
            android:maxLength="20"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout2"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/myProfilePicTextView"
        app:layout_constraintEnd_toEndOf="@+id/textInputLayout"
        app:layout_constraintStart_toStartOf="@+id/textInputLayout"
        app:layout_constraintTop_toBottomOf="@+id/myPasswordTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newPasswordText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="New password"
            android:inputType="text|textPassword"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout3"
        android:layout_width="250dp"
        android:layout_height="61dp"
        android:visibility="invisible"
        app:layout_constraintBottom_toTopOf="@+id/myBioTextView"
        app:layout_constraintEnd_toEndOf="@+id/textInputLayout2"
        app:layout_constraintStart_toStartOf="@+id/textInputLayout2"
        app:layout_constraintTop_toBottomOf="@+id/myPhoneTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newPhoneText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="New phone number"
            android:inputType="phone"
            android:maxLength="10"
            android:singleLine="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout4"
        android:layout_width="250dp"
        android:layout_height="180dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="@+id/textInputLayout3"
        app:layout_constraintStart_toStartOf="@+id/textInputLayout3"
        app:layout_constraintTop_toBottomOf="@+id/myBioTextView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/newDescText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="New BIO"
            android:inputType="text|textLongMessage|textMultiLine"
            android:maxEms="25"
            android:singleLine="false" />
    </com.google.android.material.textfield.TextInputLayout>

    <TextView
        android:id="@+id/warningText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="if u dont want to change something,\n leave the field empty"
        android:textColor="@color/design_default_color_error"
        android:visibility="invisible"
        app:layout_constraintBottom_toBottomOf="@+id/editUserinfoBtn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editUserinfoBtn"
        app:layout_constraintTop_toTopOf="@+id/editUserinfoBtn"
        app:layout_constraintVertical_bias="1.0" />

    <Button
        android:id="@+id/leavebtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:text="Profile"
        app:layout_constraintBottom_toBottomOf="@+id/editUserinfoBtn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@+id/editUserinfoBtn" />

</androidx.constraintlayout.widget.ConstraintLayout>
activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="#1B2838"
    >

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView"
        android:name="com.example.runanalyser.fragments.LoginFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="32dp"
        android:layout_marginTop="64dp"
        android:layout_marginEnd="32dp"
        android:layout_marginBottom="64dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:text="activity debug btn"
        android:visibility="gone"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
activity_navigation_drawer.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/DvirDrawerLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SearchNavigationActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.google.android.material.appbar.AppBarLayout
            android:id="@+id/appBarLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layoutDirection="ltr"
            android:visibility="visible"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">

            <com.google.android.material.appbar.MaterialToolbar
                android:id="@+id/materialToolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="@android:color/darker_gray"
                app:navigationIcon="@drawable/ic_action_menu"
                app:title="@string/app_name"
                app:titleTextColor="@color/black" />

        </com.google.android.material.appbar.AppBarLayout>

        <androidx.fragment.app.FragmentContainerView
            android:id="@+id/fragmentContainerView3"
            android:name="com.example.runanalyser.fragments.UsersPageFragment"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/appBarLayout" />
    </androidx.constraintlayout.widget.ConstraintLayout>


    <com.google.android.material.navigation.NavigationView
        android:id="@+id/DvirNavigationView"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:backgroundTint="@color/white"
        android:layoutDirection="ltr"
        app:headerLayout="@layout/nav_header_layout"
        app:menu="@menu/nav_menu" />
</androidx.drawerlayout.widget.DrawerLayout>
activity_splash_screen.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SplashScreenActivity">

    <ProgressBar
        android:id="@+id/progressBar"
        style="@style/Widget.AppCompat.ProgressBar.Horizontal"
        android:layout_width="0dp"
        android:layout_height="25dp"
        android:layout_marginStart="32dp"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="32dp"
        android:max="2500"
        android:progressDrawable="@android:drawable/progress_horizontal"
        android:progressTint="@color/design_default_color_error"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/splashIcon" />

    <ImageView
        android:id="@+id/splashIcon"
        android:layout_width="150dp"
        android:layout_height="150dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@mipmap/ic_launcher" />
</androidx.constraintlayout.widget.ConstraintLayout>
activity_users.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/profile"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".UserProfileActivity">

    <TextView
        android:id="@+id/followingCountTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="0"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/followingCount"
        app:layout_constraintEnd_toEndOf="@+id/followingCount"
        app:layout_constraintStart_toStartOf="@+id/followingCount"
        tools:text="99" />

    <TextView
        android:id="@+id/followingCount"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:text="Following"
        android:textColor="@color/gray_700"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@+id/followerCount"
        app:layout_constraintStart_toEndOf="@+id/followerCount"
        app:layout_constraintTop_toBottomOf="@+id/followerCountTxt" />

    <TextView
        android:id="@+id/followerCountTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="0"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/followerCount"
        app:layout_constraintEnd_toEndOf="@+id/followerCount"
        app:layout_constraintStart_toStartOf="@+id/followerCount"
        tools:text="99" />

    <TextView
        android:id="@+id/followerCount"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="Followers"
        android:textColor="@color/gray_700"
        android:textSize="15sp"
        app:layout_constraintStart_toStartOf="@+id/curusername"
        app:layout_constraintTop_toBottomOf="@+id/curusername" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/addGameFAB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:elevation="12dp"
        android:src="@android:drawable/ic_menu_add"
        app:backgroundTint="#85B5FF"
        app:fabSize="normal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:maxImageSize="36dp" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/searchFAB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:elevation="12dp"
        android:src="@android:drawable/ic_menu_search"
        app:backgroundTint="#85B5FF"
        app:fabSize="normal"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:maxImageSize="36dp" />

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView2"
        android:name="com.example.runanalyser.fragments.GameRCFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/profileBtn" />

    <ImageView
        android:id="@+id/profileBtn"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:clickable="true"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/ic_profile_placeholder" />

    <TextView
        android:id="@+id/curusername"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:textSize="28sp"
        app:layout_constraintStart_toEndOf="@+id/profileBtn"
        app:layout_constraintTop_toTopOf="@+id/profileBtn"
        tools:text="text" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="'s Profile"
        android:textSize="28sp"
        app:layout_constraintBottom_toBottomOf="@+id/curusername"
        app:layout_constraintStart_toEndOf="@+id/curusername"
        app:layout_constraintTop_toTopOf="@+id/curusername" />

</androidx.constraintlayout.widget.ConstraintLayout>
fragment_game_rc.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/game_rc"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fragments.GameRCFragment">

    <TextView
        android:id="@+id/textView9"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Games"
        android:textSize="34sp"
        app:layout_constraintBottom_toTopOf="@+id/gameSearchBar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/gamesRecyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="4dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/gameSearchBar" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/gameSearchBar"
        android:layout_width="379dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/gameSearchBarEditText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Search games"
            android:text="" />
    </com.google.android.material.textfield.TextInputLayout>

    <TextView
        android:id="@+id/gameCountTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="@+id/textView9"
        app:layout_constraintEnd_toStartOf="@+id/textView9"
        app:layout_constraintTop_toTopOf="@+id/textView9"
        app:layout_constraintVertical_bias="1.0"
        tools:text="99" />

</androidx.constraintlayout.widget.ConstraintLayout>
fragment_login.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/main_container"
    android:background="#2A3F5A"
    android:elevation="8dp"
    android:padding="64dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHeight_percent="0.85"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintWidth_percent="0.95">


    <!-- Username Field -->
    <TextView
        android:id="@+id/username_label"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="64dp"
        android:text="Username"
        android:textColor="#66C0F4"
        android:textSize="12sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/logUsernameEditText"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:background="@drawable/steam_field_background"
        android:hint="Enter your username"
        android:imeOptions="actionNext"
        android:padding="12dp"
        android:singleLine="true"
        android:textColor="#FFFFFF"
        android:textColorHint="#8F98A0"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/username_label" />

    <!-- Password Field -->
    <TextView
        android:id="@+id/password_label"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="Password"
        android:textColor="#66C0F4"
        android:textSize="12sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/logUsernameEditText" />

    <EditText
        android:id="@+id/logPasswordEditText"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:background="@drawable/steam_field_background"
        android:hint="Enter your password"
        android:imeOptions="actionDone"
        android:inputType="textPassword"
        android:padding="12dp"
        android:singleLine="true"
        android:textColor="#FFFFFF"
        android:textColorHint="#8F98A0"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/password_label" />

    <!-- Remember Me -->

    <!-- Login Button -->
    <Button
        android:id="@+id/loginButton"
        android:layout_width="0dp"
        android:layout_height="52dp"
        android:background="@drawable/steam_button_background"
        android:text="Log In"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/logPasswordEditText" />

    <TextView
        android:id="@+id/gotosignup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="Create an account"
        android:textColor="#66C0F4"
        android:textSize="14sp"
        app:layout_constraintStart_toStartOf="@+id/loginButton"
        app:layout_constraintTop_toBottomOf="@+id/loginButton" />

</androidx.constraintlayout.widget.ConstraintLayout>
fragment_other_user_profile.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/otherProfile"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fragments.OtherUserProfileFragment">

    <TextView
        android:id="@+id/followingCount2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:text="Following"
        android:textColor="@color/gray_700"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@+id/followerCount2"
        app:layout_constraintStart_toEndOf="@+id/followerCount2"
        app:layout_constraintTop_toBottomOf="@+id/followerCountTxt2" />

    <TextView
        android:id="@+id/followerCount2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="Followers"
        android:textColor="@color/gray_700"
        android:textSize="15sp"
        app:layout_constraintStart_toStartOf="@+id/curusername2"
        app:layout_constraintTop_toBottomOf="@+id/curusername2" />

    <TextView
        android:id="@+id/followerCountTxt2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="0"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/followerCount2"
        app:layout_constraintEnd_toEndOf="@+id/followerCount2"
        app:layout_constraintStart_toStartOf="@+id/followerCount2"
        tools:text="99" />

    <TextView
        android:id="@+id/followingCountTxt2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="0"
        android:textSize="20sp"
        app:layout_constraintBottom_toTopOf="@+id/followingCount2"
        app:layout_constraintEnd_toEndOf="@+id/followingCount2"
        app:layout_constraintStart_toStartOf="@+id/followingCount2"
        tools:text="99" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/closeFragFAB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:elevation="12dp"
        android:rotation="180"
        android:src="@android:drawable/ic_menu_revert"
        app:backgroundTint="#85B5FF"
        app:fabSize="normal"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:maxImageSize="36dp" />

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView4"
        android:name="com.example.runanalyser.fragments.GameRCFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/profileBtn2" />

    <ImageView
        android:id="@+id/profileBtn2"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:clickable="true"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@android:drawable/ic_menu_report_image"
        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/curusername2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:textSize="28sp"
        app:layout_constraintStart_toEndOf="@+id/profileBtn2"
        app:layout_constraintTop_toTopOf="@+id/profileBtn2"
        tools:text="text" />

    <TextView
        android:id="@+id/textView8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="'s Profile"
        android:textSize="28sp"
        app:layout_constraintBottom_toBottomOf="@+id/curusername2"
        app:layout_constraintStart_toEndOf="@+id/curusername2"
        app:layout_constraintTop_toTopOf="@+id/curusername2" />
</androidx.constraintlayout.widget.ConstraintLayout>
fragment_signup

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/main_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#2A3F5A"
    android:elevation="8dp"
    android:padding="64dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHeight_percent="0.85"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintWidth_percent="0.95">


    <!-- Username Field -->
    <TextView
        android:id="@+id/username_label"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="64dp"
        android:text="Username"
        android:textColor="#66C0F4"
        android:textSize="12sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/signUsernameEditText"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:background="@drawable/steam_field_background"
        android:hint="Enter your username"
        android:imeOptions="actionNext"
        android:maxLength="20"
        android:padding="12dp"
        android:singleLine="true"
        android:textColor="#FFFFFF"
        android:textColorHint="#8F98A0"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/username_label" />

    <!-- Password Field -->
    <TextView
        android:id="@+id/password_label"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="Password"
        android:textColor="#66C0F4"
        android:textSize="12sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/signUsernameEditText" />

    <EditText
        android:id="@+id/confirm_signPasswordEditText"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:background="@drawable/steam_field_background"
        android:hint="Enter your password"
        android:imeOptions="actionDone"
        android:inputType="textPassword"
        android:padding="12dp"
        android:singleLine="true"
        android:textColor="#FFFFFF"
        android:textColorHint="#8F98A0"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/confirm_password_label" />

    <TextView
        android:id="@+id/confirm_password_label"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="Confirm password"
        android:textColor="#66C0F4"
        android:textSize="12sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/signPasswordEditText" />

    <EditText
        android:id="@+id/signPasswordEditText"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:background="@drawable/steam_field_background"
        android:hint="Enter your password"
        android:imeOptions="actionDone"
        android:inputType="textPassword"
        android:padding="12dp"
        android:singleLine="true"
        android:textColor="#FFFFFF"
        android:textColorHint="#8F98A0"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/password_label" />

    <!-- Remember Me -->

    <!-- Login Button -->
    <Button
        android:id="@+id/signupButton"
        android:layout_width="0dp"
        android:layout_height="52dp"
        android:background="@drawable/steam_button_background"
        android:text="Sign Up"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/signPasswordEditText" />

    <TextView
        android:id="@+id/gotologin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        android:text="Already have an acount?"
        android:textColor="#66C0F4"
        android:textSize="14sp"
        app:layout_constraintStart_toStartOf="@+id/signupButton"
        app:layout_constraintTop_toBottomOf="@+id/signupButton" />

</androidx.constraintlayout.widget.ConstraintLayout>
fragment_users_page

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/usersRecyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="4dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/usersSearchBar" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/usersSearchBar"
        android:layout_width="379dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="80dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/usersSearchBarEditText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Search"
            android:text="" />
    </com.google.android.material.textfield.TextInputLayout>

    <TextView
        android:id="@+id/textView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Users"
        android:textSize="34sp"
        app:layout_constraintBottom_toTopOf="@+id/usersSearchBar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/userCountTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="@+id/textView5"
        app:layout_constraintEnd_toStartOf="@+id/textView5"
        app:layout_constraintTop_toTopOf="@+id/textView5"
        app:layout_constraintVertical_bias="1.0"
        tools:text="99" />

</androidx.constraintlayout.widget.ConstraintLayout>
game_item

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="108dp">

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="0dp"
        android:layout_height="8dp"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:srcCompat="?android:attr/listDivider" />

    <TextView
        android:id="@+id/gameName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:text="Name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/gameRatingTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:text="Rating:"
        app:layout_constraintBottom_toTopOf="@+id/gameName"
        app:layout_constraintStart_toEndOf="@+id/gameName"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/gameCompletionTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Status:"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="@+id/gameRatingTxt"
        app:layout_constraintStart_toStartOf="@+id/gameRatingTxt"
        app:layout_constraintTop_toBottomOf="@+id/gameName" />

    <TextView
        android:id="@+id/gameGenre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Genre"
        app:layout_constraintBottom_toTopOf="@+id/gameCompletionTxt"
        app:layout_constraintEnd_toEndOf="@+id/gameRating"
        app:layout_constraintStart_toStartOf="@+id/gameRatingTxt"
        app:layout_constraintTop_toBottomOf="@+id/gameRatingTxt" />

    <TextView
        android:id="@+id/gameRating"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4dp"
        android:text="10/10"
        app:layout_constraintBottom_toBottomOf="@+id/gameRatingTxt"
        app:layout_constraintStart_toEndOf="@+id/gameRatingTxt"
        app:layout_constraintTop_toTopOf="@+id/gameRatingTxt" />

    <TextView
        android:id="@+id/gameCompletion"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4dp"
        android:text="100%"
        app:layout_constraintBottom_toBottomOf="@+id/gameCompletionTxt"
        app:layout_constraintStart_toEndOf="@+id/gameCompletionTxt"
        app:layout_constraintTop_toTopOf="@+id/gameCompletionTxt" />

    <TextView
        android:id="@+id/gameReviewTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:text="Review:"
        app:layout_constraintBottom_toTopOf="@+id/gameCompletion"
        app:layout_constraintStart_toEndOf="@+id/gameRating"
        app:layout_constraintTop_toBottomOf="@+id/gameRating" />

    <TextView
        android:id="@+id/gameReview"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:ellipsize="end"
        android:maxLines="3"
        android:text="TextView"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toEndOf="@+id/gameReviewTxt"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
nav_header_layout

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    android:backgroundTint="@android:color/darker_gray"
    android:foregroundTint="@android:color/darker_gray">

    <ImageView
        android:id="@+id/closeDrawerImage"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:clickable="true"
        android:scaleType="centerCrop"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@android:drawable/ic_delete" />

    <TextView
        android:id="@+id/textView7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:text="Hello"
        android:textSize="28sp"
        app:layout_constraintStart_toEndOf="@+id/navProfile"
        app:layout_constraintTop_toTopOf="@+id/navProfile" />

    <ImageView
        android:id="@+id/navProfile"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginStart="24dp"
        android:layout_marginTop="32dp"
        android:clickable="true"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@android:drawable/sym_def_app_icon"
        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:textSize="28sp"
        app:layout_constraintStart_toStartOf="@+id/textView7"
        app:layout_constraintTop_toBottomOf="@+id/textView7"
        tools:text="User" />
</androidx.constraintlayout.widget.ConstraintLayout>
user_item

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="108dp">

    <!-- Profile Picture (Left Side) -->

    <ImageView
        android:id="@+id/user_rc_pfp"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/ic_profile_placeholder"
        tools:srcCompat="@tools:sample/avatars" />

    <!-- User Info Column (Right of Profile Picture) -->
    <TextView
        android:id="@+id/userrc_username"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="12dp"
        android:layout_marginTop="8dp"
        android:textAppearance="?attr/textAppearanceTitleMedium"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/user_rc_pfp"
        app:layout_constraintTop_toTopOf="parent"
        tools:text="Name" />

    <!-- First Row: Games Count -->
    <TextView
        android:id="@+id/userrc_games_lbl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="12dp"
        android:layout_marginTop="4dp"
        android:text="Games:"
        app:layout_constraintStart_toEndOf="@id/user_rc_pfp"
        app:layout_constraintTop_toBottomOf="@id/userrc_username" />

    <TextView
        android:id="@+id/userrc_games"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4dp"
        app:layout_constraintBaseline_toBaselineOf="@id/userrc_games_lbl"
        app:layout_constraintStart_toEndOf="@id/userrc_games_lbl"
        tools:text="10" />

    <!-- Second Row: Rating -->
    <TextView
        android:id="@+id/userrc_ratings_lbl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="12dp"
        android:layout_marginTop="4dp"
        android:text="Rating:"
        app:layout_constraintStart_toEndOf="@id/user_rc_pfp"
        app:layout_constraintTop_toBottomOf="@id/userrc_games_lbl" />

    <TextView
        android:id="@+id/userrc_ratings"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4dp"
        app:layout_constraintBaseline_toBaselineOf="@id/userrc_ratings_lbl"
        app:layout_constraintStart_toEndOf="@id/userrc_ratings_lbl"
        tools:text="10" />

    <!-- Third Row: Phone -->
    <TextView
        android:id="@+id/userrc_phone"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="12dp"
        android:layout_marginTop="4dp"
        app:layout_constraintStart_toEndOf="@id/user_rc_pfp"
        app:layout_constraintTop_toBottomOf="@id/userrc_ratings_lbl"
        tools:text="123-456-7890" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="8dp"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:srcCompat="?android:attr/listDivider" />

    <TextView
        android:id="@+id/textView10"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="44dp"
        android:layout_marginTop="4dp"
        android:text="Bio:"
        app:layout_constraintStart_toEndOf="@+id/userrc_games_lbl"
        app:layout_constraintTop_toBottomOf="@+id/userrc_username" />

    <TextView
        android:id="@+id/userrc_bio"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="4dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="12dp"
        android:ellipsize="end"
        app:layout_constraintBottom_toTopOf="@+id/imageView"
        app:layout_constraintEnd_toStartOf="@+id/followBtn"
        app:layout_constraintStart_toEndOf="@+id/textView10"
        app:layout_constraintTop_toTopOf="@+id/textView10"
        app:layout_constraintVertical_bias="0.0" />

    <ImageView
        android:id="@+id/followBtn"
        android:layout_width="32dp"
        android:layout_height="32dp"
        android:layout_marginEnd="8dp"
        android:clickable="false"
        app:layout_constraintBottom_toTopOf="@+id/imageView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/userrc_username"
        app:srcCompat="@android:drawable/ic_input_add" />

    <ImageView
        android:id="@+id/unfollowBtn"
        android:layout_width="32dp"
        android:layout_height="32dp"
        android:layout_marginEnd="8dp"
        android:clickable="false"
        android:rotation="45"
        app:layout_constraintBottom_toTopOf="@+id/imageView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/userrc_username"
        app:srcCompat="@android:drawable/ic_delete"
        tools:visibility="invisible" />

    <!-- Add this at the end of your original ConstraintLayout -->
    <!-- Send to back -->

    <!-- Then add android:background="@android:color/white" to your root ConstraintLayout -->
</androidx.constraintlayout.widget.ConstraintLayout>

nav_menu.xml

<?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/userspage"
        android:enabled="true"
        android:icon="@drawable/ic_profile_placeholder"
        android:title="Users"
        android:titleCondensed="bout"
        android:visible="true" />

    <item
        android:id="@+id/logoutBtn"
        android:icon="@drawable/ic_logout"
        android:title="Logout" />
    <item
        android:id="@+id/abtmepage"
        android:enabled="true"
        android:icon="@drawable/ic_about_me"
        android:title="About the creator"
        android:visible="true" />

</menu>

ic_profile_placeholder.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="120dp"
    android:height="120dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="@color/gray_300"
        android:pathData="M12,12c2.21,0 4,-1.79 4,-4s-1.79,-4 -4,-4 -4,1.79 -4,4 1.79,4 4,4zM12,14c-2.67,0 -8,1.34 -8,4v2h16v-2c0,-2.66 -5.33,-4 -8,-4z" />
</vector>

ic_logout.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="?attr/colorControlNormal">

    <!-- Logout icon path data -->
    <path
        android:fillColor="@android:color/white"
        android:pathData="M17,8l-1.41,1.41L17.17,11H9v2h8.17l-1.58,1.58L17,16l4,-4M5,5h7V3H5C3.9,3 3,3.9 3,5v14c0,1.1 0.9,2 2,2h7v-2H5V5z"/>
</vector>


circle_background.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="?attr/colorControlNormal">

    <!-- Logout icon path data -->
    <path
        android:fillColor="@android:color/white"
        android:pathData="M17,8l-1.41,1.41L17.17,11H9v2h8.17l-1.58,1.58L17,16l4,-4M5,5h7V3H5C3.9,3 3,3.9 3,5v14c0,1.1 0.9,2 2,2h7v-2H5V5z"/>
</vector>

ic_about_me.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="?attr/colorControlNormal">

    <!-- Person base -->
    <path
        android:fillColor="@android:color/white"
        android:pathData="M12,4c2.21,0 4,1.79 4,4s-1.79,4 -4,4 -4,-1.79 -4,-4 1.79,-4 4,-4zM12,14c4.42,0 8,1.79 8,4v2H4v-2c0,-2.21 3.58,-4 8,-4z"/>

    <!-- Info circle -->
    <path
        android:fillColor="@android:color/white"
        android:pathData="M11,7h2v2h-2zM11,11h2v6h-2z"
        android:strokeWidth="1"
        android:strokeColor="@android:color/white"/>
</vector>

ic_add_gray.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="#333333"
    android:alpha="0.6">
  <path
      android:fillColor="@android:color/white"
      android:pathData="M19,13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/>
</vector>

ic_action_menu.xml

<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="#333333"
    android:alpha="0.6">
  <path
      android:fillColor="@android:color/white"
      android:pathData="M3,18h18v-2L3,16v2zM3,13h18v-2L3,11v2zM3,6v2h18L21,6L3,6z"/>
</vector>
ic_launcher.xml

<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
  <background android:drawable="@mipmap/ic_launcher_background"/>
  <foreground android:drawable="@mipmap/ic_launcher_foreground"/>
  <monochrome android:drawable="@mipmap/ic_launcher_monochrome"/>
</adaptive-icon>
Database


AppDatabase

package com.example.runanalyser.databasestuff;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Game.class, Follower.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract GameDao gameDao();

    public abstract FollowerDao followerDao();

    private static final int NUM_OF_THREADS = 4;

    public static final ExecutorService dtbWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

User

package com.example.runanalyser.databasestuff;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    public int id;

    public String username;
    public String password;
    public String phonenumber;
    public String description;
    public String pfpURI;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

UserDao

package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    long insertUser(User user);

    @Update
    void editUser(User user);

    @Delete
    void delUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User getUserByUsernameNPassword(String username, String password);

    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM users WHERE userId = :id")
    User getUserByID(int id);

    @Query("SELECT COUNT(*) AS game_item_count\n" +
            "FROM GAMES \n" +
            "WHERE Games.userId = :id;")
    int countConnectedGamesToUserById(int id);

    @Query("SELECT COUNT(*) FROM users")
    int countUsers();

    @Query("SELECT Round(AVG(Games.rating),2) AS average_rating FROM Games WHERE Games.userId = :id")
    double getAvgReviewFromAUser(int id);

    @Query("SELECT * FROM users where users.username like :s ||'%'")
    LiveData<List<User>> getUsersListByName(String s);

    @Query("SELECT * FROM users where users.username like :s ||'%' and users.userId != :id")
    LiveData<List<User>> getUsersListByNameExCur(String s, int id);
}

UserAdapter

package com.example.runanalyser.databasestuff;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.Globals;
import com.example.runanalyser.R;

import java.util.List;

public class UserAdapter extends ListAdapter<User, UserAdapter.UserViewHolder> {
    private List<User> users;
    private Context context;
    private UserAdapter.OnUserClickListener onUserClickListener;

    public UserAdapter(List<User> users, Context context, UserAdapter.OnUserClickListener ouscl) {
        super(new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.id == newItem.id && oldItem.username.equals(newItem.username);
            }
        });
        this.users = users;
        this.context = context;
        this.onUserClickListener = ouscl;
    }


    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        UserAdapter.UserViewHolder userViewHolder = new UserAdapter.UserViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPos = userViewHolder.getAdapterPosition();
                User tempuser = users.get(adapterPos);
                String Userstring = tempuser.username;
                onUserClickListener.onUserClick(tempuser);
            }
        });

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        UserDao userDao = AppDatabase.getDatabase(context).userDao();
        FollowerDao followerDao = AppDatabase.getDatabase(context).followerDao();

        User user = users.get(position);
        holder.nameView.setText(user.username);
        holder.phoneView.setText(user.phonenumber);
        holder.bioView.setText(user.description);
        new Thread(() -> {
            Double avgRating = userDao.getAvgReviewFromAUser(user.id);
            int gameCount = userDao.countConnectedGamesToUserById(user.id);

            holder.itemView.post(() -> {
                holder.ratingView.setText(String.valueOf(avgRating));
                holder.gamesView.setText(String.valueOf(gameCount));
            });
        }).start();
        if (user.pfpURI != null) holder.pfpView.setImageURI(Uri.parse(user.pfpURI));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("--> Entered edit thread");
                boolean isFollowing = followerDao.getFollowItemByIds(Globals.getCurUser().id, user.id) != null;
                boolean isFollowed = followerDao.getFollowItemByIds(user.id, Globals.getCurUser().id) != null;
                System.out.println("--> got follow info");
                ((Activity) context).runOnUiThread(() -> {
                    System.out.println("--> entered UI thread");
                    updateButtonStates(user,holder,isFollowing,isFollowed);
                    System.out.println("--> Finished UI thread");
                });
            }
        };

        AppDatabase.dtbWriteExecutor.execute(runnable);



        holder.followbtn.setOnClickListener(view ->AppDatabase.dtbWriteExecutor.execute(() -> {
            Follower follower = new Follower(Globals.getCurUser().id, user.id);
            followerDao.insertFollower(follower);
            System.out.println("--> added follow");
            AppDatabase.dtbWriteExecutor.execute(runnable);
        }));
        holder.unfollowbtn.setOnClickListener(view ->AppDatabase.dtbWriteExecutor.execute(() -> {
            Follower follower = followerDao.getFollowItemByIds(Globals.getCurUser().id, user.id);
            followerDao.delFollower(follower);
            System.out.println("--> added follow");
            AppDatabase.dtbWriteExecutor.execute(runnable);

        }));
    }

    private void updateButtonStates(User user, UserAdapter.UserViewHolder holder, boolean isFollowing, boolean isFollowed) {
        holder.followbtn.setVisibility(isFollowing ? View.INVISIBLE : View.VISIBLE);
        holder.unfollowbtn.setVisibility(isFollowing ? View.VISIBLE : View.INVISIBLE);

        holder.followbtn.setClickable(!isFollowing);
        holder.unfollowbtn.setClickable(isFollowing);

        if (isFollowing && isFollowed) {
            holder.nameView.setText(user.username + " * Friend");
        } else if (isFollowing) {
            holder.nameView.setText(user.username + " * Following");
        } else {
            holder.nameView.setText(user.username);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        submitList(users);
    }

    public void setOnUserClickListener(UserAdapter.OnUserClickListener onUserClickListener) {
        this.onUserClickListener = onUserClickListener;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView ratingView;
        TextView gamesView;
        TextView phoneView;
        TextView bioView;
        ImageView pfpView;
        ImageView followbtn;
        ImageView unfollowbtn;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


            nameView = itemView.findViewById(R.id.userrc_username);
            ratingView = itemView.findViewById(R.id.userrc_ratings);
            gamesView = itemView.findViewById(R.id.userrc_games);
            phoneView = itemView.findViewById(R.id.userrc_phone);
            bioView = itemView.findViewById(R.id.userrc_bio);
            pfpView = itemView.findViewById(R.id.user_rc_pfp);
            followbtn = itemView.findViewById(R.id.followBtn);
            unfollowbtn = itemView.findViewById(R.id.unfollowBtn);
        }
    }

    public interface OnUserClickListener {
        void onUserClick(User user);
    }
}

Game

package com.example.runanalyser.databasestuff;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "games", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "userId", onDelete = ForeignKey.CASCADE))
public class Game {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gameId")
    public int id;

    public int userId;

    public String name;
    public String genre;
    public int completion;
    public int rating;
    public String review;

    public Game() {
    }
}

GameDao

package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDao {

    @Insert
    Void insertGame(Game game);

    @Update
    Void editGame(Game game);

    @Delete
    Void delGame(Game game);

    @Query("SELECT * FROM games WHERE gameId = :id")
    Game getGameByID(int id);

    @Query("Select * from games where games.userId = :id and games.name like :name || '%' order by rating,genre desc")
    LiveData<List<Game>> getGamesForUserid(int id, String name);

    @Query("SELECT COUNT(*) \n" +
            "FROM GAMES \n" +
            "WHERE Games.userId = :id;")
    int countConnectedGamesToUserId(int id);
    }

GameAdapter

package com.example.runanalyser.databasestuff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.R;

import java.util.List;

public class GameAdapter extends ListAdapter<Game, GameAdapter.GameViewHolder> {

    private List<Game> games;
    private Context context;
    private OnGameClickListener onGameClickListener;

    public GameAdapter(List<Game> games, Context context, OnGameClickListener ouscl) {
        super(new DiffUtil.ItemCallback<Game>() {
            @Override
            public boolean areItemsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
                return oldItem.id == newItem.id && oldItem.name.equals(newItem.name);
            }
        });
        this.games = games;
        this.context = context;
        this.onGameClickListener = ouscl;
    }


    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPos = gameViewHolder.getAdapterPosition();
                Game tempgame = games.get(adapterPos);
                String Gamestring = tempgame.name;
                onGameClickListener.onGameClick(tempgame);
            }
        });

        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.nameView.setText(games.get(position).name);
        holder.reviewView.setText(String.valueOf(games.get(position).review));
        holder.ratingView.setText(games.get(position).rating +"/10");
        holder.genreView.setText(String.valueOf(games.get(position).genre));
        holder.statusView.setText(games.get(position).completion+"%");
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setGames(List<Game> games) {
        this.games = games;
        submitList(games);
    }

    public void setOnGameClickListener(OnGameClickListener onGameClickListener) {
        this.onGameClickListener = onGameClickListener;
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView ratingView;
        TextView statusView;
        TextView genreView;
        TextView reviewView;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);


            nameView = itemView.findViewById(R.id.gameName);
            ratingView = itemView.findViewById(R.id.gameRating);
            statusView = itemView.findViewById(R.id.gameCompletion);
            genreView = itemView.findViewById(R.id.gameGenre);
            reviewView = itemView.findViewById(R.id.gameReview);
        }
    }

    public interface OnGameClickListener {
        void onGameClick(Game game);
    }
}


Follower

package com.example.runanalyser.databasestuff;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "followers", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followerId", onDelete = ForeignKey.CASCADE), @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followingId", onDelete = ForeignKey.CASCADE)},
primaryKeys = {"followerId","followingId"})

public class Follower {
    public int followerId;
    public int followingId;

    public Follower(int followerId, int followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }
}

FollowerDao

package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FollowerDao {
    @Insert
    void insertFollower(Follower follower);

    @Update
    void editFollower(Follower follower);

    @Delete
    void delFollower(Follower follower);

    @Query("SELECT *\n" +
            "FROM Users\n" +
            "JOIN Followers ON users.userId = followers.followingId\n" +
            "WHERE followers.followerId = :id\n" +
            "ORDER BY users.username ASC")
    LiveData<List<User>> getFollowingListById(int id);

    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followingId\n" +
            "WHERE Followers.followerId = :id")
    int countFollowing(int id);

    @Query("SELECT *\n" +
            "FROM Users\n" +
            "JOIN Followers ON users.userId = followers.followerId\n" +
            "WHERE followers.followingId = :id\n" +
            "ORDER BY users.username ASC")
    LiveData<List<User>> getFollowerListById(int id);

    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followerId\n" +
            "WHERE Followers.followingId = :id")
    int countFollowers(int id);

    @Query("SELECT * \n" +
            "FROM Followers \n" +
            "WHERE followerId = :followerUserId \n" +
            "AND followingId = :targetUserId")
    Follower getFollowItemByIds(int followerUserId, int targetUserId);

}


Fragment

GameRCFragment

package com.example.runanalyser.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.EditGameActivity;
import com.example.runanalyser.Globals;
import com.example.runanalyser.R;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.Game;
import com.example.runanalyser.databasestuff.GameAdapter;
import com.example.runanalyser.databasestuff.GameDao;
import com.example.runanalyser.databasestuff.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class GameRCFragment extends Fragment {

    private final GameAdapter gameAdapter = new GameAdapter(new ArrayList<>(), getActivity(), new GameAdapter.OnGameClickListener() {
        @Override
        public void onGameClick(Game game) {
            Intent intent = new Intent(getActivity(), EditGameActivity.class);
            intent.putExtra(Globals.DEST_ID, game.id);
            intent.putExtra(Globals.ITEM_EDITABLE,user == Globals.getCurUser());
            getActivity().startActivity(intent);
        }
    });


    private final MediatorLiveData<List<Game>> gamesLiveData = new MediatorLiveData<>();
    private LiveData<List<Game>> currentGamesData;
    private User user;

    private Activity activity;

    public GameRCFragment() {
        this.user = Globals.getCurUser();
    }

    public GameRCFragment(User user) {
        this.user = user;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_rc, container, false);
        AppDatabase dataBase = AppDatabase.getDatabase(activity);
        GameDao gameDao = dataBase.gameDao();

        activity = requireActivity();
        RecyclerView gameRc;
        gameRc = view.findViewById(R.id.gamesRecyclerView);
        gameRc.setLayoutManager(new LinearLayoutManager(activity));
        gameRc.setAdapter(gameAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AppDatabase.dtbWriteExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        if (direction == ItemTouchHelper.LEFT) {
                            List<Game> gameList = gameAdapter.getCurrentList();
                            Game destGame = gameList.get(viewHolder.getAdapterPosition());
                            final CharSequence[] options = {"Are you sure you want to delete this game?\nThis cannot be undone.", "Delete", "Cancel"};
                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                            builder.setTitle("Delete Game?");
                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (options[which].equals("Delete")) {
                                        AppDatabase.dtbWriteExecutor.execute(() -> {
                                            gameDao.delGame(destGame);
                                        });
                                    } else if (options[which].equals("Cancel")) {
                                        dialog.dismiss();
                                    } else if (which == 1) {
                                    }
                                }
                            });
                            activity.runOnUiThread(()->builder.show());
                        }
                    }
                });
            }
        });
        itemTouchHelper.attachToRecyclerView(gameRc);

        TextInputLayout searchGameInput = view.findViewById(R.id.gameSearchBar);
        EditText searchText = searchGameInput.getEditText();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                gamesLiveData.removeSource(currentGamesData);

                currentGamesData = gameDao.getGamesForUserid(user.id, editable.toString());

                gamesLiveData.addSource(currentGamesData, new Observer<List<Game>>() {
                    @Override
                    public void onChanged(List<Game> games) {
                        gamesLiveData.setValue(games);
                    }
                });
            }
        });
        gamesLiveData.observe((LifecycleOwner) activity, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                gameAdapter.setGames(games);
            }
        });

        currentGamesData = gameDao.getGamesForUserid(user.id, "");
        gamesLiveData.addSource(currentGamesData, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                gamesLiveData.setValue(games);
            }
        });

        TextView gamecount = view.findViewById(R.id.gameCountTxt);
        new Thread(()->{
            int count = gameDao.countConnectedGamesToUserId(user.id);
            activity.runOnUiThread(()-> gamecount.setText(String.valueOf(count)));
        }).start();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

LoginFragment

package com.example.runanalyser.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.runanalyser.Globals;
import com.example.runanalyser.MainActivity;
import com.example.runanalyser.R;
import com.example.runanalyser.UserProfileActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;

public class LoginFragment extends Fragment {

    private AppDatabase appDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        appDatabase = AppDatabase.getDatabase(requireContext());

        EditText usernameEditText = view.findViewById(R.id.logUsernameEditText);
        EditText passwordEditText = view.findViewById(R.id.logPasswordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill all fields🥀🥀🥀", Toast.LENGTH_SHORT).show();
            } else {
                new Thread(() -> {
                    User user = appDatabase.userDao().getUserByUsernameNPassword(username, password);
                    requireActivity().runOnUiThread(() -> {
                        if (user != null) {
                            Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                            Globals.setCurUser(user);
                            Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getActivity(), "Invalid credentials🥀🥀🥀", Toast.LENGTH_SHORT).show();
                        }
                    });
                }).start();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView switchfrag = view.findViewById(R.id.gotosignup);

        switchfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragToSignup();
            }
        });
    }
}

OtherUserProfileFragment

package com.example.runanalyser.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.runanalyser.Globals;
import com.example.runanalyser.MainActivity;
import com.example.runanalyser.R;
import com.example.runanalyser.UserProfileActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;

public class LoginFragment extends Fragment {

    private AppDatabase appDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        appDatabase = AppDatabase.getDatabase(requireContext());

        EditText usernameEditText = view.findViewById(R.id.logUsernameEditText);
        EditText passwordEditText = view.findViewById(R.id.logPasswordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill all fields🥀🥀🥀", Toast.LENGTH_SHORT).show();
            } else {
                new Thread(() -> {
                    User user = appDatabase.userDao().getUserByUsernameNPassword(username, password);
                    requireActivity().runOnUiThread(() -> {
                        if (user != null) {
                            Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                            Globals.setCurUser(user);
                            Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getActivity(), "Invalid credentials🥀🥀🥀", Toast.LENGTH_SHORT).show();
                        }
                    });
                }).start();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView switchfrag = view.findViewById(R.id.gotosignup);

        switchfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragToSignup();
            }
        });
    }
}

SignupFragment

package com.example.runanalyser.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.runanalyser.EditUserActivity;
import com.example.runanalyser.Globals;
import com.example.runanalyser.MainActivity;
import com.example.runanalyser.R;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;

public class SignupFragment extends Fragment {

    private AppDatabase appDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        appDatabase = AppDatabase.getDatabase(requireContext());

        EditText usernameEditText = view.findViewById(R.id.signUsernameEditText);
        EditText passwordEditText = view.findViewById(R.id.signPasswordEditText);
        EditText confirmPasswordEditText = view.findViewById(R.id.confirm_signPasswordEditText);
        Button signupButton = view.findViewById(R.id.signupButton);

        signupButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmpassword = confirmPasswordEditText.getText().toString().trim();

            if (validateInput(username, password, confirmpassword)) {
                new Thread(() -> {
                    User existingUser = appDatabase.userDao().getUserByUsername(username);
                    User newUser = new User(username, password);
                    if (existingUser == null) {
                        newUser.id = ((int) appDatabase.userDao().insertUser(newUser));
                    }
                    getActivity().runOnUiThread(() -> {
                        if (existingUser != null) {
                            showToast("Username already exists🥀🥀🥀");
                        } else {
                            showToast("Signup successfully");
                            Globals.setCurUser(newUser);
                            Intent intent = new Intent(getActivity(), EditUserActivity.class);
                            startActivity(intent);
                        }
                    });
                }).start();
            }
        });

        return view;
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInput(@NonNull String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showToast("Please fill all fields🥀🥀🥀");
            return false;
        }
        if (username.length() < 3) {
            showToast("Username must be 3 characters or longer🥀🥀🥀");
            return false;
        }
        if (username.matches(".*\\d.*")) {
            showToast("Username can't contain any numbers🥀🥀🥀");
            return false;
        }
        if (password.length() < 8) {
            showToast("Password must be 8 characters or longer🥀🥀🥀");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            showToast("Password must contain at least one number🥀🥀🥀");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            showToast("Password must contain at least one capital letter🥀🥀🥀");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            showToast("Passwords do not match🥀🥀🥀");
            return false;
        }
        return true; // All validations passed
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView switchfrag = view.findViewById(R.id.gotologin);

        switchfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragToLogin();
            }
        });
    }
}

UsersPageFragment

package com.example.runanalyser.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.Globals;
import com.example.runanalyser.R;
import com.example.runanalyser.SearchNavigationActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;
import com.example.runanalyser.databasestuff.UserAdapter;
import com.example.runanalyser.databasestuff.UserDao;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class UsersPageFragment extends Fragment {
    private UserAdapter userAdapter;
    private MediatorLiveData<List<User>> usersLiveData = new MediatorLiveData<>();
    private LiveData<List<User>> currentUsersData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppDatabase dataBase = AppDatabase.getDatabase(requireContext());
        UserDao userDao = dataBase.userDao();
        RecyclerView userRC = view.findViewById(R.id.usersRecyclerView);

        TextView usercount = view.findViewById(R.id.userCountTxt);
        new Thread(()->{
            int count = userDao.countUsers();
            getActivity().runOnUiThread(()-> usercount.setText(String.valueOf(count)));
        }).start();

        // Initialize adapter
        userAdapter = new UserAdapter(new ArrayList<>(), getActivity(), new UserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                SearchNavigationActivity nav = (SearchNavigationActivity) getActivity();
                nav.switchFragToNewUserProfile(new OtherUserProfileFragment(user));
            }
        });

        userRC.setLayoutManager(new LinearLayoutManager(requireContext()));
        userRC.setAdapter(userAdapter);

        // Search functionality
        TextInputLayout searchUserInput = view.findViewById(R.id.usersSearchBar);
        EditText searchText = searchUserInput.getEditText();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                usersLiveData.removeSource(currentUsersData);
                currentUsersData = userDao.getUsersListByNameExCur(editable.toString(), Globals.getCurUser().id);
                usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));
            }
        });

        // LiveData observation
        usersLiveData.observe(getViewLifecycleOwner(), users -> userAdapter.setUsers(users));

        currentUsersData = userDao.getUsersListByNameExCur("", Globals.getCurUser().id);
        usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersLiveData.removeSource(currentUsersData);
    }
}


Activity

AbtMeActivity

package com.example.runanalyser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbtMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abt_me);
        ImageView wedoabitoftrolling = findViewById(R.id.imageView4);

        wedoabitoftrolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

    }
}

EditGameActivity

package com.example.runanalyser;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.Game;
import com.example.runanalyser.databasestuff.GameDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class EditGameActivity extends AppCompatActivity {

    private GameDao gameDao;
    private Game curGame;

    private TextView NameTxt;
    private TextView GenreTxt;
    private TextView ReviewTxt;
    private TextView RatingTxt;
    private TextView StatusTxt;

    private ArrayList<View> visibilityViews = new ArrayList<>();
    private TextInputEditText editName;
    private TextInputEditText editGenre;
    private TextInputEditText editRating;
    private TextInputEditText editReview;
    private TextInputEditText editStatus;

    private Button editInfo;
    private Button saveEdits;
    private FloatingActionButton delGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editGame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AppDatabase appDatabase = AppDatabase.getDatabase(this);

        gameDao = appDatabase.gameDao();

        NameTxt = findViewById(R.id.gameNameView);
        GenreTxt = findViewById(R.id.gameGenreView);
        ReviewTxt = findViewById(R.id.gameReviewView);
        RatingTxt = findViewById(R.id.gameRatingView);
        StatusTxt = findViewById(R.id.gameStatusView);
        delGame = findViewById(R.id.deleteGameFAB);

        visibilityViews.add(findViewById(R.id.gtextInputLayout));
        visibilityViews.add(findViewById(R.id.gtextInputLayout2));
        visibilityViews.add(findViewById(R.id.gtextInputLayout3));
        visibilityViews.add(findViewById(R.id.gtextInputLayout4));
        visibilityViews.add(findViewById(R.id.gtextInputLayout5));
        visibilityViews.add(findViewById(R.id.warningTextg));
        editName = findViewById(R.id.newNameText);
        editGenre = findViewById(R.id.newGenreText);
        editRating = findViewById(R.id.newRatingText);
        editReview = findViewById(R.id.newReviewText);
        editStatus = findViewById(R.id.newStatusText);
        editInfo = findViewById(R.id.editGameinfoBtn);
        saveEdits = findViewById(R.id.saveGameEditsBtn);

        int curgameid = getIntent().getIntExtra(Globals.DEST_ID, 0);

        if (!getIntent().getBooleanExtra(Globals.ITEM_EDITABLE, false)) {
            editInfo.setActivated(false);
            saveEdits.setActivated(false);
            delGame.setActivated(false);
            editInfo.setVisibility(View.GONE);
            saveEdits.setVisibility(View.GONE);
            delGame.setVisibility(View.GONE);
        }

        if (curgameid == 0) {
            curGame = new Game();
            curGame.userId = Globals.getCurUser().id;
        } else {
            new Thread(() -> {
                curGame = gameDao.getGameByID(curgameid);
                runOnUiThread(() -> refreshGameInfo());
                System.out.println("--> cur game in thread " + curGame);
            }).start();
            System.out.println("--> cur game after thread " + curGame);
        }

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (View layout : visibilityViews) {
                    layout.setVisibility(View.VISIBLE);
                }
                editName.setVisibility(View.VISIBLE);
                editGenre.setVisibility(View.VISIBLE);
                editRating.setVisibility(View.VISIBLE);
                editReview.setVisibility(View.VISIBLE);
                saveEdits.setVisibility(View.VISIBLE);
                editStatus.setVisibility(View.VISIBLE);
                editInfo.setVisibility(View.INVISIBLE);
            }
        });

        saveEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("---> on click check start" + this + " <---> " + Globals.getCurUser().id);

                String name = editName.getText().toString();
                String genre = editGenre.getText().toString();
                String rating = (editRating.getText().toString());
                String status = (editStatus.getText().toString());
                String desc = editReview.getText().toString();
                if (validateValue(name, genre, rating, status, desc)) {
                    curGame.name = name;
                    curGame.genre = genre;
                    curGame.rating = Integer.parseInt(rating);
                    curGame.completion = Integer.parseInt(status);
                    curGame.review = desc;
                    new Thread(() -> {
                        if (curgameid != 0) {
                            gameDao.editGame(curGame);
                        } else {
                            gameDao.insertGame(curGame);
                            finish();
                        }
                        System.out.println("---> on click check end" + this + " <---> " + Globals.getCurUser());
                    }).start();
                    for (View layout : visibilityViews) {
                        layout.setVisibility(View.INVISIBLE);
                    }
                    editName.setVisibility(View.INVISIBLE);
                    editGenre.setVisibility(View.INVISIBLE);
                    editRating.setVisibility(View.INVISIBLE);
                    editReview.setVisibility(View.INVISIBLE);
                    editStatus.setVisibility(View.INVISIBLE);
                    saveEdits.setVisibility(View.INVISIBLE);
                    editInfo.setVisibility(View.VISIBLE);
                    refreshGameInfo();
                }

            }
        });

        delGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("--> fab clicked " + curGame);
                final CharSequence[] options = {"Are you sure you want to delete this game?\nThis cannot be undone.", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditGameActivity.this);
                builder.setTitle("Delete Game?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Delete")) {
                            AppDatabase.dtbWriteExecutor.execute(() -> {
                                gameDao.delGame(curGame);
                                finish();
                            });
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        } else if (which == 1) {
                        }
                    }
                });
                builder.show();
            }
        });
    }

    private void showToast(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(EditGameActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateValue(String name, String genre, String rating, String status, String desc) {

        if (name.isEmpty() || genre.isEmpty() || rating.isEmpty() || status.isEmpty() || desc.isEmpty()) {
            showToast("All fields must be filled");
            return false;
        }
        int rate = Integer.parseInt(rating);
        if (rate > 10 || rate < 1) {
            showToast("Rating must be between 1 and 10");
            return false;
        }
        int completion = Integer.parseInt(status);
        if (completion > 100 || completion < 0) {
            showToast("Completion status must be between 0 and 100");
            return false;
        }

        return true;
    }

    private void refreshGameInfo() {
        NameTxt.setText(curGame.name);
        editName.setText(curGame.name);
        GenreTxt.setText(curGame.genre);
        editGenre.setText(curGame.genre);
        ReviewTxt.setText(curGame.review);
        editReview.setText(curGame.review);
        RatingTxt.setText(String.valueOf(curGame.rating));
        editRating.setText(String.valueOf(curGame.rating));
        StatusTxt.setText(String.valueOf(curGame.completion));
        editStatus.setText(String.valueOf(curGame.completion));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();

    }
}

EditUserActivity

package com.example.runanalyser;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;
import com.example.runanalyser.databasestuff.UserDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class EditUserActivity extends AppCompatActivity {


    private AppDatabase appDatabase;
    private UserDao userDao;

    private ImageView previewProfilePic;
    private TextView UsernameTxt;
    private TextView PasswordTxt;
    private TextView DescriptionTxt;
    private TextView PhoneTxt;

    private ArrayList<View> visibilityViews = new ArrayList<>();
    private TextInputEditText editUsername;
    private TextInputEditText editPassword;
    private TextInputEditText editPhone;
    private TextInputEditText editDesc;

    private Button editUser;
    private Button saveEdits;
    private Button exitbtn;
    private FloatingActionButton delUser;
    private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {
            if (result) {
                dispatchTakePictureIntent();
            } else showToast("The app needs camera access");
        }
    });

    private ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri o) {
            if (o != null) {
                Uri uri = copyImageToAppDir(o);
                Globals.getCurUser().pfpURI = uri.toString();
                previewProfilePic.setImageURI(uri);
            }
        }
    });

    private ActivityResultLauncher<Intent> takePictureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == Activity.RESULT_OK) {
                Intent data = o.getData();
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                Uri uri = saveImageToInternalStorage(imageBitmap);
                previewProfilePic.setImageURI(uri);
                Globals.getCurUser().pfpURI = uri.toString();
            } else {
                showToast("Camera permission is required to take photos");
            }
        }
    });

    private Uri copyImageToAppDir(Uri contentUri) {
        InputStream is = null;
        OutputStream os = null;
        try {
// Create file access components
            is = getContentResolver().openInputStream(contentUri);
            File outputDir = getApplicationContext().getFilesDir();
            File outputFile = new File(outputDir, "copied_image_" + System.currentTimeMillis() + ".jpg");
            os = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int length;
// Copy the file
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            os.flush();
// Return the Uri of the copied file
            return Uri.fromFile(outputFile);
        } catch (IOException e) {
            showToast("Failed to copy image: ");
            e.printStackTrace();
            return null;
        } finally {
// Ensure all streams are properly closed
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Uri saveImageToInternalStorage(Bitmap bitmap) {
        String imageName = "image_" + System.currentTimeMillis() + ".jpg";
        File storageDir = new File(getApplicationContext().getFilesDir(), "YourAppImages");
        if (!storageDir.exists()) {
            if (!storageDir.mkdirs()) {
                showToast("Failed to create directory");
                return null;
            }
        }
        File imageFile = new File(storageDir, imageName);
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            showToast("Image saved to internal storage: " + imageFile.getAbsolutePath());
            return Uri.fromFile(imageFile);
        } catch (IOException e) {
            showToast("Failed to save image");
            e.printStackTrace();
        }
        return null;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            takePictureLauncher.launch(takePictureIntent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editUser), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        appDatabase = AppDatabase.getDatabase(this);
        userDao = appDatabase.userDao();

        previewProfilePic = findViewById(R.id.profilePreview);
        UsernameTxt = findViewById(R.id.myUsernameView);
        PasswordTxt = findViewById(R.id.myPasswordView);
        DescriptionTxt = findViewById(R.id.myBioView);
        PhoneTxt = findViewById(R.id.myPhoneView);
        exitbtn = findViewById(R.id.leavebtn);
        delUser = findViewById(R.id.deleteUserFAB);

        visibilityViews.add(findViewById(R.id.textInputLayout));
        visibilityViews.add(findViewById(R.id.textInputLayout2));
        visibilityViews.add(findViewById(R.id.textInputLayout3));
        visibilityViews.add(findViewById(R.id.textInputLayout4));
        visibilityViews.add(findViewById(R.id.warningText));
        editUsername = findViewById(R.id.newUsernameText);
        editPassword = findViewById(R.id.newPasswordText);
        editPhone = findViewById(R.id.newPhoneText);
        editDesc = findViewById(R.id.newDescText);
        editUser = findViewById(R.id.editUserinfoBtn);
        saveEdits = findViewById(R.id.saveEditsBtn);

        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (View layout : visibilityViews) {
                    layout.setVisibility(View.VISIBLE);
                }
                editUsername.setVisibility(View.VISIBLE);
                editPassword.setVisibility(View.VISIBLE);
                editPhone.setVisibility(View.VISIBLE);
                editDesc.setVisibility(View.VISIBLE);
                saveEdits.setVisibility(View.VISIBLE);
                previewProfilePic.setClickable(true);
                exitbtn.setVisibility(View.INVISIBLE);
                editUser.setVisibility(View.INVISIBLE);
            }
        });

        saveEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String phone = editPhone.getText().toString();
                String desc = editDesc.getText().toString();
                new Thread(() -> {
                    if (!username.isEmpty()) {
                        if (validateUsernameInput(username)) {
                            User checkuser = appDatabase.userDao().getUserByUsername(username);
                            if (checkuser != null) {
                                showToast("Username already exists");
                            } else Globals.getCurUser().username = username;
                        }
                    }
                    if (!password.isEmpty()) {
                        if (validatePasswordInput(password))
                            Globals.getCurUser().password = password;
                    }
                    if (!phone.isEmpty()) {
                        Globals.getCurUser().phonenumber = phone;
                    }
                    if (!desc.isEmpty()) {
                        Globals.getCurUser().description = desc;
                    }

                    userDao.editUser(Globals.getCurUser());
                }).start();

                for (View layout : visibilityViews) {
                    layout.setVisibility(View.INVISIBLE);
                }
                editUsername.setVisibility(View.INVISIBLE);
                editPassword.setVisibility(View.INVISIBLE);
                editPhone.setVisibility(View.INVISIBLE);
                editDesc.setVisibility(View.INVISIBLE);
                saveEdits.setVisibility(View.INVISIBLE);
                previewProfilePic.setClickable(false);
                exitbtn.setVisibility(View.VISIBLE);
                editUser.setVisibility(View.VISIBLE);
                refreshUserInfo();
            }
        });

        previewProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Take Picture", "Pick from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditUserActivity.this);
                builder.setTitle("Choose your image source");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Take Picture")) {
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                            }
                        } else if (options[which].equals("Pick from Gallery")) {
                            pickImageLauncher.launch("image/*");
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
        previewProfilePic.setClickable(false);


        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditUserActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

        delUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] options = {"Are you sure you want to delete your user?\n This cannot be undone.", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditUserActivity.this);
                builder.setTitle("Delete User?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Delete")) {
                            AppDatabase.dtbWriteExecutor.execute(()->{
                                userDao.delUser(Globals.getCurUser());
                                Globals.logOut(EditUserActivity.this);
                            });
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        }else if (which == 1) {
                        }
                    }
                });
                builder.show();
            }
        });

        refreshUserInfo();
    }

    private void showToast(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(EditUserActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateUsernameInput(@NonNull String username) {
        if (username.length() < 3) {
            showToast("Username must be 3 characters or longer");
            return false;
        }
        if (username.matches(".*\\d.*")) {
            showToast("Username can't contain any numbers");
            return false;
        }

        return true; // All validations passed
    }

    private boolean validatePasswordInput(@NonNull String password) {
        if (password.length() < 8) {
            showToast("Password must be 8 characters or longer");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            showToast("Password must contain at least one number");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            showToast("Password must contain at least one capital letter");
            return false;
        }
        return true;
    }

    private void refreshUserInfo() {
        UsernameTxt.setText(Globals.getCurUser().username);
        PasswordTxt.setText(Globals.getCurUser().password);
        DescriptionTxt.setText(Globals.getCurUser().description);
        PhoneTxt.setText(Globals.getCurUser().phonenumber);
        if (Globals.getCurUser().pfpURI != null)
            previewProfilePic.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
    }


}

MainActivity

package com.example.runanalyser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.fragments.LoginFragment;
import com.example.runanalyser.fragments.SignupFragment;

public class MainActivity extends AppCompatActivity {
    private final LoginFragment loginFrag = new LoginFragment();
    private final SignupFragment signupFrag = new SignupFragment();
    private final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button debugbtn = findViewById(R.id.btn);
        debugbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AbtMeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void changeFragToLogin() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, loginFrag, "Login");
        transaction.commit();
    }

    public void changeFragToSignup() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, signupFrag, "Signup");
        transaction.commit();
    }
}

SearchNavigationActivity

package com.example.runanalyser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.fragments.OtherUserProfileFragment;
import com.example.runanalyser.fragments.UsersPageFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class SearchNavigationActivity extends AppCompatActivity {

    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private MaterialToolbar materialToolbar;

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final UsersPageFragment usersPageFragment = new UsersPageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        drawerLayout = findViewById(R.id.DvirDrawerLayout);
        navView = findViewById(R.id.DvirNavigationView);
        materialToolbar = findViewById(R.id.materialToolbar);
        View headerView = navView.getHeaderView(0);
        TextView usernametxt = headerView.findViewById(R.id.textView6);
        ImageView navProfilebtn = headerView.findViewById(R.id.navProfile);
        ImageView closeDrawerBtn = headerView.findViewById(R.id.closeDrawerImage);

        if (Globals.getCurUser() != null) {
            usernametxt.setText(Globals.getCurUser().username);
            if (Globals.getCurUser().pfpURI != null)
                navProfilebtn.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
        } else usernametxt.setText("Empty user");

        navProfilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--> profile btn clicked");
                Intent intent = new Intent(SearchNavigationActivity.this, UserProfileActivity.class);
                SearchNavigationActivity.this.startActivity(intent);
            }
        });
        closeDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--> close btn clicked");
                drawerLayout.closeDrawer(navView);
            }
        });

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("--> opened");
                drawerLayout.openDrawer(navView);
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                int itemId = item.getItemId();
                if (itemId == R.id.userspage) {
                    System.out.println("--> userpage btn clicked");
                    switchFragToUserpage();
                } else if (itemId == R.id.abtmepage) {
                    System.out.println("--> about me btn clicked");
                    intent = new Intent(SearchNavigationActivity.this, AbtMeActivity.class);
                    startActivity(intent);
                    finish();
                } else if (itemId == R.id.logoutBtn) {
                    System.out.println("--> logout btn clicked");
                    Globals.logOut(SearchNavigationActivity.this);
                }
                return false;
            }
        });
    }

    public void switchFragToUserpage() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView3, usersPageFragment, "Users Search");
        transaction.commit();
    }

    public void switchFragToNewUserProfile(OtherUserProfileFragment usersProfileFragment) {
        System.out.println("---> clicked a user");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView3, usersProfileFragment, "New User Profile");
        System.out.println("---> replaced transaction");
        transaction.commit();
        System.out.println("---> commited transaction");
    }
}

SplashScreenActivity

package com.example.runanalyser;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar pb = findViewById(R.id.progressBar);
        CountDownTimer countDownTimer = new CountDownTimer(2500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setProgress(2500 - (int) millisUntilFinished);
                pb.setAlpha((float) (2500 - millisUntilFinished) / 2500);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
        };
        countDownTimer.start();
    }
}

UserProfileActivity

package com.example.runanalyser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.fragments.GameRCFragment;
import com.example.runanalyser.fragments.UsersPageFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class UserProfileActivity extends AppCompatActivity {

    private ImageView editUserBtn;
    private TextView curName;
    private FloatingActionButton addgameFab;
    private FloatingActionButton searchFab;

    AppDatabase database;
    private TextView followers;
    private TextView following;
    private final GameRCFragment myGamesFrag = new GameRCFragment(Globals.getCurUser());
    private final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_users);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        switchFragToGamesPage();

        database = AppDatabase.getDatabase(this);

        searchFab = findViewById(R.id.searchFAB);
        addgameFab = findViewById(R.id.addGameFAB);
        editUserBtn = findViewById(R.id.profileBtn);
        curName = findViewById(R.id.curusername);
        followers = findViewById(R.id.followerCountTxt);
        following = findViewById(R.id.followingCountTxt);

        System.out.println("---> " + this + " <---> " + Globals.getCurUser());
        System.out.println("---> " + this + " <---> " + Globals.getCurUser().username);

        new Thread(() -> {
            int ercount = database.followerDao().countFollowers(Globals.getCurUser().id);
            int ngcount = database.followerDao().countFollowing(Globals.getCurUser().id);
            runOnUiThread(() -> {
                followers.setText(String.valueOf(ercount));
                following.setText(String.valueOf(ngcount));
            });
        }).start();
        curName.setText(Globals.getCurUser().username);
        if (Globals.getCurUser().pfpURI != null)
            editUserBtn.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
        editUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, EditUserActivity.class);
                startActivity(intent);
            }
        });
        addgameFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, EditGameActivity.class);
                intent.putExtra(Globals.DEST_ID, 0);
                intent.putExtra(Globals.ITEM_EDITABLE, true);
                startActivity(intent);

            }
        });
        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, SearchNavigationActivity.class));
            }
        });

//        followers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(UserProfileActivity.this, SearchNavigationActivity.class);
//                i.putExtra(Globals.NAV_OPENING, 1);
//                startActivity(i);            }
//        });
//        following.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(UserProfileActivity.this, SearchNavigationActivity.class);
//                i.putExtra(Globals.NAV_OPENING, 2);
//                startActivity(i);
//            }
//        });

    }
    public void switchFragToGamesPage() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, myGamesFrag, "Your games");
        transaction.commit();
    }
}

Globals

package com.example.runanalyser;

import android.app.Activity;
import android.content.Intent;

import com.example.runanalyser.databasestuff.User;

public class Globals {
    public static final String DEST_ID = "SNCJQWNFBWN";
    public static final String ITEM_EDITABLE = "SKNMFKJDSNVJKNA";
    private static User curUser;

    public static User getCurUser() {
        return curUser;
    }

    public static void setCurUser(User curUser) {
        Globals.curUser = curUser;
    }

    public static void logOut(Activity context) {
        curUser = null;
        context.finishAffinity();
        context.startActivity(new Intent(context, MainActivity.class));
    }

}



