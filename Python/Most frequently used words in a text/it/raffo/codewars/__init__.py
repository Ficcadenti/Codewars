import operator
import re

def top_3_words(text):
    
    if not text:
        return []
    
    conta_parole = {}
    
    for parola in re.split("[^a-z']+|\\s", text.lower()):
        if parola in conta_parole.keys():
            conta_parole[parola] += 1
        elif parola == "" or parola == "'" or parola == "'''":
            continue
        else:
            conta_parole[parola] = 1
    
    migliori_tre = [k for k, v in sorted(conta_parole.items(),
                                  key=operator.itemgetter(1), reverse=True)[:3]]
    
    return migliori_tre


print(top_3_words("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"))