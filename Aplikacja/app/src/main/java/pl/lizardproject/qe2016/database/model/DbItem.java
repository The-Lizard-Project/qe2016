package pl.lizardproject.qe2016.database.model;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

@Entity
class DbItem {
    @Key
    @Generated
    int id;

    String name;

    Boolean isChecked;
}
