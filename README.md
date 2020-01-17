<h1>Logiciel de gestion d'un port de plaisance</h1>
<p><em> <strong>Auteurs : </strong>Florian GIGOT & Quentin LEVIEUX</em></p>
<h2>Introduction</h2>
<p><em>
Réalisation d'une application permettant à un chef de port de gérer sa port de de plaisance.<br /><br />  
Via cette application, un responsable de port peut gérer facilement ses quais, ses emplacements de bateau, ses bateaux et les propriétaires de bateau.<br /><br /> 
<strong>Temps pour développer le projet :</strong> 1 semaine <br />
<strong>Langage :</strong> JAVA (avec librairie JDBC et Hibernate) <br />
<strong>Interface :</strong> SWING <br />
<strong>Base de données :</strong> mySQL <br />
</em></p>
<h2>Informations pour lancer le projet</h2>
<p><em>
Les étapes à réaliser pour que cela fonctionne, à faire la premiere fois :<br/>
<ul>
<li>Veuillez créer une BDD se nommant "port"</li>     
<li>Ajouter le pilote au projet (mysql-connector-java-8.0.18.jar) et les librairies Hibernate</li>
<li>Retirer les balises de commentaire à la ligne 16 du fichier persistence.xml </li>
<li>Exécuter le main de la classe MainBDD, qui ajoutera des éléments dans la BDD</li>
<li>Remettre en commentaire la ligne 16 du fichier persistence.xml </li>
<li>Executer le main de la classe Main, qui lance l'application</li>
</ul>
<strong>Pour exécuter le projet : dans Package Main se trouve main.java </strong>
</em></p>
<h2>Spécifications techniques</h2>
<h3>MCD de la base de données</h3>
<h3>Modèle Général de l’architecture MVC du logiciel</h3>
<h3>Modèle UML du logiciel</h3>
<h2>Informations complémentaires</h2>
<p><em>
 L’application permet la gestion des quais d’un port de plaisance. Cette gestion passe par la gestion des propriétaires de bateau, des bateaux, des emplacements des bateaux et des quais du port. </br></br>
<strong>Pour utiliser les boutons Modifier et Supprimer veuillez cliquer sur un item avant de cliquer sur le bouton.</strong></br>
</em></p>
<h3>Page principale</h3>
<h4>Détails</h4>
<em><ul>
<li>Dans cette onglet, le manager du port peut choisir quel quai il veut gérer et à action à un large panel d’action tel que l’accès aux pages Gestion des quais, Gestion des propriétaires, Gestion des emplacements et Recherche sur voilier.</li>
<li>Le manager peut également ajouter, supprimer et/ou modifier un bateau via cette page. Un bateau est associé à un unique propriétaire et à un unique emplacement. Un bateau ne peut pas changer d’emplacement directement depuis le bouton modifier, pour effectuer cette opération supprimer le bateau et recréer le.</li>
<li>Des informations pratiques telles que le nombre d’emplacement occupé par des bateaux, le nombre de voilier et le de bateau à moteur sur le quai sélectionné sont disponibles.</li>
<li>La liste des bateaux du quai sélectionné est disponible pour une meilleure visualisation des données.</li>
</ul>
<h4>Prévisualisation</h4>
<h3>Page de gestion des quais</h3>
<h4>Détails</h4>
<li>Dans cette onglet, le manager du port peut créer des quais et supprimer des quais dans l’application.</li>
<li>Une liste de quai est disponible pour la visualisation des quais.</li>
<h4>Prévisualisation</h4>
<h3>Page gestion des propriétaires</h3>
<h4>Détails</h4>
<li>Dans cette onglet, le manager du port peut ajouter, modifier et supprimer des propriétaires de bateau. Un propriétaire peut posséder plusieurs bateaux.</li>
<li>Une liste de propriétaire est disponible pour la visualisation des propriétaires.</li>
<h4>Prévisualisation</h4>
<h3>Page de gestion des emplacements</h3>
<h4>Détails</h4>
<li>Dans cette onglet, le manager du port peut ajouter, modifier et supprimer des emplacements de bateau. A noter, le quai impose une limite de nombre d’emplacement.</li>
<li>Une information pratique indique le nombre d’emplacement créé et le nombre d’emplacement que le quai peut contenir.</li>
<li>Une liste d’emplacement est disponible pour la visualisation des emplacements de bateau créé.</li>
<h4>Prévisualisation</h4>
<h3>Page de recherche sur voilier</h3>
<h4>Détails</h4>
<li>Demande à l’utilisateur une taille de voile et retourne la liste des voiliers avec une surface de supérieur à la valeur entrée. Une information sur le nombre de résultat est également disponible.</li>
<h4>Prévisualisation</h4>
