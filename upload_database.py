import _mysql
import configparser
import json

config = configparser.ConfigParser()
# set up configurations in your own settings.cfg file
config.read('settings.cfg')

db = json.load((open('pokemon_db.json')))

myDB = _mysql.connect(host=config['DEFAULT']['endpoint'],user=config['DEFAULT']['user'], passwd=config['DEFAULT']['passwd'], db=config['DEFAULT']['database'])
# print(myDB)
myDB.query("DROP TABLE Pokemon")
myDB.query("CREATE TABLE IF NOT EXISTS Pokemon(pkmn_no INT KEY, name VARCHAR(255), gen INT, type1 VARCHAR(255), type2 VARCHAR(255), sprite TEXT)")

for pkmn in db:
    # print(pkmn)
    # print(db[pkmn])
    q = "INSERT INTO Pokemon VALUES (" + str(pkmn) + ", '" + db[pkmn]['name'] + "', " + str(db[pkmn]['gen'])

    if str(db[pkmn]['type']).find(",") != -1:
        split = db[pkmn]['type'].split(', ')
        q += ", '" + split[0] + "', '" + split[1] + "'"
    else:
        q+= ", '" + db[pkmn]['type'] + "', NULL"
    
    q+=",'" + db[pkmn]['sprite'] + "')"
    # print(q)
    myDB.query(q)    
myDB.close()