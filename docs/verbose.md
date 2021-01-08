**Commentaire**  ( *id_commentaire*, commentaire, auteur, *id_sondage* )
* Le champ *id_commentaire* constitue la clef primaire de la table. C'était déjà un identifiant de l'entité *Commentaire*.
* Les champs *commentaire* et auteur étaient déjà de simples attributs de l'entité *Commentaire*.
* Le champ *id_sondage* est une clef étrangère. Il a migré à partir de l'entité Sondage par l'association de dépendance fonctionnelle Contient en perdant son caractère identifiant.

**Choix** ( *id_choix*, date, *id_sondage* )
* Le champ *id_choix* constitue la clef primaire de la table. C'était déjà un identifiant de l'entité *Choix*.
* Le champ *date* était déjà un simple attribut de l'entité *Choix*.
* Le champ *id_sondage* est une clef étrangère. Il a migré à partir de l'entité *Sondage* par l'association de dépendance fonctionnelle *Est composé* de en perdant son caractère identifiant.

**Sondage** ( *id_sondage*, nom, description, date_de_fin, est_disponible )
* Le champ *id_sondage* constitue la clef primaire de la table. C'était déjà un identifiant de l'entité *Sondage*.
* Les champs *nom, description, date_de_fin* et *est_disponible* étaient déjà de simples attributs de l'entité *Sondage*.

**Option** ( *id_option*, nom )
* Le champ *id_option* constitue la clef primaire de la table. C'était déjà un identifiant de l'entité *Option*.
* Le champ *nom* était déjà un simple attribut de l'entité *Option*.

**Vote** ( *id_vote*, auteur, *id_option*, *id_choix* )
* Le champ *id_vote* constitue la clef primaire de la table. C'était déjà un identifiant de l'entité *Vote*.
* Le champ *auteur* était déjà un simple attribut de l'entité *Vote*.
* Le champ *id_option* est une clef étrangère. Il a migré à partir de l'entité *Option* par l'association de dépendance fonctionnelle A pour valeur en perdant son caractère identifiant.
* Le champ *id_choix* est une clef étrangère. Il a migré à partir de l'entité *Choix* par l'association de dépendance fonctionnelle Est voté par en perdant son caractère identifiant.