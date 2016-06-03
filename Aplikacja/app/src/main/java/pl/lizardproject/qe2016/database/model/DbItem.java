package pl.lizardproject.qe2016.database.model;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import pl.lizardproject.qe2016.model.Category;
import pl.lizardproject.qe2016.model.Priority;

@Entity
class DbItem {
    @Key
    @Generated
    int id;

    String name;
    Boolean isChecked;
    Category category;
    Priority priority;
}