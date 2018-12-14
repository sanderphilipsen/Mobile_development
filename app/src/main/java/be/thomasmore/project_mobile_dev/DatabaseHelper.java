package be.thomasmore.project_mobile_dev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 5;
    // Database Name
    private static final String DATABASE_NAME = "Project";

    // uitgevoerd bij instantiatie van DatabaseHelper
    // -> als database nog niet bestaat, dan creëren (call onCreate)
    // -> als de DATABASE_VERSION hoger is dan de huidige versie,
    //    dan upgraden (call onUpgrade)

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // methode wordt uitgevoerd als de database gecreëerd wordt
    // hierin de tables creëren en opvullen met gegevens
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_GEBRUIKER = "CREATE TABLE gebruiker (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "voornaam TEXT," +
                "familienaam TEXT," +
                "token TEXT)";
        db.execSQL(CREATE_TABLE_GEBRUIKER);
        String CREATE_TABLE_STOORNIS = "CREATE TABLE stoornis (" +
                "id INTEGER PRIMARY KEY," +
                "stoornis TEXT)";
        db.execSQL(CREATE_TABLE_STOORNIS);
        String CREATE_TABLE_KLANK = "CREATE TABLE klank (" +
                "id INTEGER PRIMARY KEY," +
                "klank TEXT)";
        db.execSQL(CREATE_TABLE_KLANK);
        String CREATE_TABLE_DOELKLANK = "CREATE TABLE doelklank (" +
                "id INTEGER PRIMARY KEY," +
                "doelklank TEXT," +
                "klankId INTEGER, " +
                "stoornisId INTEGER, " +
                "FOREIGN KEY (klankId) REFERENCES klank(id), " +
                "FOREIGN KEY (stoornisId) REFERENCES stoornis(id))";
        db.execSQL(CREATE_TABLE_DOELKLANK);
        String CREATE_TABLE_PAAR = "CREATE TABLE paar (" +
                "id INTEGER PRIMARY KEY," +
                "eerstepaar TEXT," +
                "tweedepaar TEXT, " +
                "doelklankId INTEGER, " +
                "FOREIGN KEY (doelklankId) REFERENCES doelklank(id))";
        db.execSQL(CREATE_TABLE_PAAR);
        String CREATE_TABLE_SPELTYPE = "CREATE TABLE speltype (" +
                "id INTEGER PRIMARY KEY," +
                "naam TEXT)";
        db.execSQL(CREATE_TABLE_SPELTYPE);
        insertGebruikers(db);
        insertStoornissen(db);
        insertKlanken(db);
        insertDoelklanken(db);
        insertParen(db);
        insertSpelTypes(db);

    }



    private void insertGebruikers(SQLiteDatabase db) {


    }
    private void insertStoornissen(SQLiteDatabase db) {
        db.execSQL("INSERT INTO stoornis (id,stoornis) VALUES (1, 'Stopping');");
        db.execSQL("INSERT INTO stoornis (id,stoornis) VALUES (2, 'Fronting');");
    }
    private void insertKlanken(SQLiteDatabase db) {
        db.execSQL("INSERT INTO klank (id, klank) VALUES (1, 'Finaal');");
        db.execSQL("INSERT INTO klank (id, klank) VALUES (2, 'Initiaal');");
    }
    private void insertDoelklanken(SQLiteDatabase db) {
        //fronting-finaal
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (1,'K-T',1,2);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (2,'NG-N',1,2);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (3,'G-S',1,2);");
        //fronting-initiaal
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (4,'K-T',2,2);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (5,'G-S/V',2,2);");
        //stopping-finaal
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (6,'S-T',1,1);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (7,'CH-T',1,1);");
        //stopping-initiaal
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (8,'G-K',2,1);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (9,'S/Z-T',2,1);");
        db.execSQL("INSERT INTO doelklank (id,doelklank, klankId,stoornisId) VALUES (10,'F-T',2,1);");
    }
    private void insertParen(SQLiteDatabase db) {
        //FRONTING
             //FINAAL
                 //K-T
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (1,'bek','bed',1);");
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (2,'nek','net',1);");
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (3,'bak','bad',1);");
                //NG-N
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (4,'pang','pan',2);");
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (5,'tong','ton',2);");
                 //G-S
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (6,'buig','buis',3);");
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (7,'leeg','lees',3);");
                     db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (8,'dag','das',3);");
            //INITIAAL
                 //K-T
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (9,'koe','toe',4);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (10,'kou','touw',4);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (11,'kam','tam',4);");
                //G-S/V
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (12,'guus','suus',5);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (13,'goed','voet',5);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (14,'goud','fout',5);");
        //STOPPING
            //FINAAL
                //S-T
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (15,'boos','boot',6);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (16,'bos','bot',6);");
                //CH-T
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (17,'pech','pet',7);");
           //INITIAAL
                //G-K
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (18,'gat','kat',8);");
                //S/Z-T
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (19,'sok','kat',9);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (20,'zak','tak',9);");
                //F-T
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (21,'fee','thee',10);");
                    db.execSQL("INSERT INTO paar (id,eerstepaar,tweedepaar,doelklankId) VALUES (22,'fien','tien',10);");
    }

    private void insertSpelTypes(SQLiteDatabase db) {
        db.execSQL("INSERT INTO speltype (id, naam) VALUES (1, 'Spel 1');");
        db.execSQL("INSERT INTO speltype (id, naam) VALUES (2, 'Spel 2');");
    }

    // methode wordt uitgevoerd als database geupgrade wordt
    // hierin de vorige tabellen wegdoen en opnieuw creëren
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS gebruiker");
        db.execSQL("DROP TABLE IF EXISTS stoornis");
        db.execSQL("DROP TABLE IF EXISTS klank");
        db.execSQL("DROP TABLE IF EXISTS doelklank");
        db.execSQL("DROP TABLE IF EXISTS paar");
        db.execSQL("DROP TABLE IF EXISTS speltype");

        // Create tables again
        onCreate(db);
    }

    //-------------------------------------------------------------------------------------------------
    //  CRUD Operations
    //-------------------------------------------------------------------------------------------------

    // insert-methode met ContentValues
    public long insertGebruiker(Gebruiker gebruiker) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("voornaam", gebruiker.getVoornaam());
        values.put("familienaam", gebruiker.getFamilienaam());
        values.put("token", gebruiker.getToken());
        long id = db.insert("gebruiker", null, values);

        db.close();
        return id;
    }

    // update-methode met ContentValues
    public boolean updateGebruiker(Gebruiker gebruiker) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("voornaam", gebruiker.getVoornaam());
        values.put("familienaam", gebruiker.getFamilienaam());
        values.put("token", gebruiker.getToken());

        int numrows = db.update(
                "gebruiker",
                values,
                "id = ?",
                new String[] { String.valueOf(gebruiker.getId()) });

        db.close();
        return numrows > 0;
    }

    // delete-methode
    public boolean deleteGebruiker(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        int numrows = db.delete(
                "gebruiker",
                "id = ?",
                new String[] { String.valueOf(id) });

        db.close();
        return numrows > 0;
    }

    // query-methode
    public Gebruiker getGebruiker(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "gebruiker",      // tabelnaam
                new String[] { "id", "voornaam", "familienaam","token" }, // kolommen
                "id = ?",  // selectie
                new String[] { String.valueOf(id) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Gebruiker gebruiker = new Gebruiker();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            gebruiker = new Gebruiker(cursor.getLong(0),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3));
        }
        cursor.close();
        db.close();
        return gebruiker;
    }
    public Klank getKlank(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "klank",      // tabelnaam
                new String[] { "id", "klank" }, // kolommen
                "id = ?",  // selectie
                new String[] { String.valueOf(id) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Klank klank = new Klank();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            klank = new Klank(cursor.getLong(0),
                    cursor.getString(1));
        }
        cursor.close();
        db.close();
        return klank;
    }
    public Klank getKlankByKlank(String zoekKlank) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "klank",      // tabelnaam
                new String[] { "id", "klank" }, // kolommen
                "klank = ?",  // selectie
                new String[] { String.valueOf(zoekKlank) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Klank klank = new Klank();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            klank = new Klank(cursor.getLong(0),
                    cursor.getString(1));
        }
        cursor.close();
        db.close();
        return klank;
    }
    public Stoornis getStoornis(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "stoornis",      // tabelnaam
                new String[] { "id", "stoornis" }, // kolommen
                "id = ?",  // selectie
                new String[] { String.valueOf(id) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Stoornis stoornis = new Stoornis();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            stoornis = new Stoornis(cursor.getLong(0),
                    cursor.getString(1));
        }
        cursor.close();
        db.close();
        return stoornis;
    }
    public Stoornis getStoornisByStoornis(String zoekStoornis) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "stoornis",      // tabelnaam
                new String[] { "id", "stoornis" }, // kolommen
                "stoornis = ?",  // selectie
                new String[] { String.valueOf(zoekStoornis) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Stoornis stoornis = new Stoornis();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            stoornis = new Stoornis(cursor.getLong(0),
                    cursor.getString(1));
        }
        cursor.close();
        db.close();
        return stoornis;
    }
    public Doelklank getDoelklank(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "doelklank",      // tabelnaam
                new String[] { "id", "doelklank","klankId","stoornisId" }, // kolommen
                "id = ?",  // selectie
                new String[] { String.valueOf(id) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Doelklank doelklank = new Doelklank();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            doelklank = new Doelklank(cursor.getLong(0),
                    cursor.getString(1), cursor.getInt(2),cursor.getInt(3));
        }
        cursor.close();
        db.close();
        return doelklank;
    }
    public Paar getPaar(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "paar",      // tabelnaam
                new String[] { "id", "eerstepaar","tweedepaar","doelklankId" }, // kolommen
                "id = ?",  // selectie
                new String[] { String.valueOf(id) }, // selectieparameters
                null,           // groupby
                null,           // having
                null,           // sorting
                null);          // ??

        Paar paar = new Paar();
        int d = cursor.getCount();
        if (cursor.moveToFirst()) {
            paar = new Paar(cursor.getLong(0),
                    cursor.getString(1), cursor.getString(2),cursor.getInt(3));
        }
        cursor.close();
        db.close();
        return paar;
    }

    // rawQuery-methode
    public List<Gebruiker> getGebruikers() {
        List<Gebruiker> lijst = new ArrayList<Gebruiker>();

        String selectQuery = "SELECT  * FROM gebruiker ORDER BY familienaam";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Gebruiker gebruiker = new Gebruiker(cursor.getLong(0),
                        cursor.getString(1), cursor.getString(2),cursor.getString(3));
                lijst.add(gebruiker);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<Klank> getKlanken() {
        List<Klank> lijst = new ArrayList<Klank>();

        String selectQuery = "SELECT  * FROM klank ORDER BY id";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Klank klank = new Klank(cursor.getLong(0),
                        cursor.getString(1));
                lijst.add(klank);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<Stoornis> getStoornissen() {
        List<Stoornis> lijst = new ArrayList<Stoornis>();

        String selectQuery = "SELECT  * FROM stoornis ORDER BY id";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Stoornis stoornis = new Stoornis(cursor.getLong(0),
                        cursor.getString(1));
                lijst.add(stoornis);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<Doelklank> getDoelklanken() {
        List<Doelklank> lijst = new ArrayList<Doelklank>();

        String selectQuery = "SELECT  * FROM doelklank ORDER BY id";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Doelklank doelklank = new Doelklank(cursor.getLong(0),
                        cursor.getString(1), cursor.getInt(2),cursor.getInt(3));
                lijst.add(doelklank);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<Paar> getParen() {
        List<Paar> lijst = new ArrayList<Paar>();

        String selectQuery = "SELECT  * FROM paar ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Paar paar = new Paar(cursor.getLong(0),
                        cursor.getString(1), cursor.getString(2),cursor.getInt(3));
                lijst.add(paar);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<SpelType> getSpelTypes() {
        List<SpelType> lijst = new ArrayList<SpelType>();

        String selectQuery = "SELECT  * FROM speltype ORDER BY id";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                SpelType speltype = new SpelType(cursor.getLong(0),
                        cursor.getString(1));
                lijst.add(speltype);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    // rawQuery-methode
    public List<Doelklank> getDoelklankenByKlankAndStoornis(long klankid, long stoornisid) {
        List<Doelklank> lijst = new ArrayList<Doelklank>();

        String selectQuery = "SELECT  * FROM doelklank WHERE klankId=? AND stoornisId=?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[] {String.valueOf(klankid), String.valueOf(stoornisid)});

        if (cursor.moveToFirst()) {
            do {
                Doelklank doelklank = new Doelklank(cursor.getLong(0),
                        cursor.getString(1), cursor.getInt(2),cursor.getInt(3));
                lijst.add(doelklank);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    public List<Paar> getParenByDoelklankid(long doelklankid) {
        List<Paar> lijst = new ArrayList<Paar>();

        String selectQuery = "SELECT  * FROM paar WHERE doelklankId=? ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[] {String.valueOf(doelklankid)});

        if (cursor.moveToFirst()) {
            do {
                Paar paar = new Paar(cursor.getLong(0),
                        cursor.getString(1), cursor.getString(2),cursor.getInt(3));
                lijst.add(paar);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }
    // rawQuery-methode
    public int getCountGebruikers() {
        String selectQuery = "SELECT  * FROM gebruiker";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int aantal = cursor.getCount();

        cursor.close();
        db.close();
        return aantal;
    }

}
