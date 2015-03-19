# ProjetTutS4
Bastien Bournas - Mathieu Chaubet - Maxime Da Silva - Vincent Prigent -  Nicolas Sirac

## Application

L'application est une application de traitement de graphes orientés ou non.

Elle permet la visualisation, l'édition, le chargement depuis certains formats ainsi que l'application d'algorithmes spécifiques sur les graphes.


# Liste des fonctionnalités restantes

### Sélection d'arêtes ( done )

## Visualisation
### affichage des étiquettes du sommet si définie
### changement de la couleur de fond
### rendre le dessin en zone du haut impossible
### zoom/dezoom
### Gérer tout les évènements sur boutons du haut

## Traitement
### Revoir algorithme de couleur ( pourquoi pas proposer deux alternatives tant qu'à faire )
 -> Le nouvel algo doit prendre en compte une propriété des noeuds ou arêtes, deux couleurs, chaque noeud se voyant attribuer une couleur ou une autre en fonction de la valeur de la propriété
 -> Sous entendu, il faut récupérer des évènements depuis une boite de dialogue à passer en paramètre du constructeur du nouvel algo de couleur

### Revoir algorithme de taille ( pareil que précédent )
 -> Même principe, ce coup ci, c'est la taille du noeud qui change
 -> possibilité d'exporter ( sauvegarder ) le graph depuis le menu des algorithmes

### Problèmes rencontrés
Couleur des noeuds en aléatoire qui est de la même couleur que le fond
Aléatoire qui met des noeuds sous les barres du haut --> Idée de zoom/unzoom en fonction de la position des noeuds
Impossibilité de déselectionner un noeud
