package lintcode.google.level1.highfreq;

import common.Util;
import org.junit.jupiter.api.Test;

public class ReverseVowelsofaStringTest {
    @Test
    public void test1(){
        ReverseVowelsofaString s=new ReverseVowelsofaString();

        String str;
        String expect;
        String output;
        int seq=1;

        str="hello";
        expect="holle";
        output=s.reverseVowels(str);
        Util.verify(expect,output,seq++);

        str="lintcode";
        expect="lentcodi";
        output=s.reverseVowels(str);
        Util.verify(expect,output,seq++);

        str="Dh0p4PjCrZfpEa1cZc3L7xS4moVQJtLum9w86WksSNsoyh3EMh2TCsZnUJuSMV31eKlnZGhIIw2PZ7LqoYA3QORIcIuWbdTJRMe6SIvE1B8HkIanJP0t9dbdPGrZmikiDfrOjbSwqiCqbEvuFVcCGrWuSkwzz4qsLYWDCAnIIq3vhsFoXtJGtGWKRrtC2jggnZ2CertgIuTTDVrszcfpZB0E0Ewfvm0Ocs6kWglMeoctswCMM8MXEHEw5iFYayyS9HGJS1jdLD9J1Ls8Q2KBhKg2wbRx2OOAnSqGw5fKtxglC9YwFaT3kO9gACpLfeSyGkrlFSIQIX5Y4BO9emrPdxuDq5FmmwhalNkiMvwcI0rLuw2jDGknRWbDn7dwHTpwP1WAGjimsRLUrCfcNFKWnXjKVTapKdo1EsIIxa2cdMJTKcde3vNhSjFQrEGDPoBSfsbFk1KSUsZ0wGffF3mL5Q5iKOIscqLCjiEgNYmvJwH5wu53mPnLyPxEmCqEqCgUfvUOMaxbSMi2KsXiEBVZOM1ZHWFd8hRqnXFzaTPQgxHOR3wkbhz3n8wxoRjcToIM2QaOTKMYLje9dLDe0QxZEKZuS2DWUv8PwkJx7vmQcf2WG5ome8uHnWRwgNjt2PngqRttrV1QGVVNyHSzoRR8VvkUo6XqRx9fMSxuJF8e4zSbj1CnPaGz68Tr1BMjJzgPg0WarfR6tLe3wFm3aS9sFnHCSReAugmRePD6rW2JikFTO9XZR5fshTTIAmhnUUbusrjh9IDF71cMiZf8AUEDI7RvsSivmEWlR3TrWxvsbHGJBiJn2rjfQJt3nrkTxjyaRFCBH6CRRlUCG7BxFf10aH0RE8dmegR7QsjNyL28lCFdhbJojOICdK93aBceU051ti9aMD6nC75eukwvZbk2wNUp8BEYMTszTLX7oMlwR4z5uadZ2I6bXINbv4jjzayC0qXznun9l7Ov7x9jhk15YLMdr97XFbsJj1ow0L3a";
        expect="Dh0p4PjCrZfpao1cZc3L7xS4mOVQJtLum9w86WksSNsayh3IMh2TCsZnIJaSMV31uKlnZGhoEw2PZ7LqUYu3QeRaciUWbdTJRMe6SavI1B8HkOonJP0t9dbdPGrZmekEDfrajbSwqUCqbaviFVcCGrWESkwzz4qsLYWDCinIEq3vhsFUXtJGtGWKRrtC2jggnZ2CArtgiITTDVrszcfpZB0u0Uwfvm0Ucs6kWglMAIctswCMM8MXOHiw5eFYuyyS9HGJS1jdLD9J1Ls8Q2KBhKg2wbRx2AeanSqGw5fKtxglC9YwFeT3ka9gaCpLfeSyGkrlFSuQoX5Y4BU9omrPdxuDq5FmmwhelNkoMvwcU0rLuw2jDGknRWbDn7dwHTpwP1WEGjemsRLerCfcNFKWnXjKVTOpKda1IsooxO2cdMJTKcda3vNhSjFQrOGDPEBSfsbFk1KSisZ0wGffF3mL5Q5iKaOscqLCjUUgNYmvJwH5wE53mPnLyPxEmCquqCgEfviIMOxbSMi2KsXUoBVZEM1ZHWFd8hRqnXFzeTPQgxHaR3wkbhz3n8wxIRjcTIEM2QoaTKMYLjU9dLDi0QxZAKZuS2DWIv8PwkJx7vmQcf2WG5ima8uHnWRwgNjt2PngqRttrV1QGVVNyHSzeRR8VvkOI6XqRx9fMSxIJF8e4zSbj1CnPAGz68Tr1BMjJzgPg0WOrfR6tLa3wFm3AS9sFnHCSROOagmRiPD6rW2JEkFTE9XZR5fshTToemhnOEbEsrjh9uDF71cMIZf8eoIDI7RvsSAvmuWlR3TrWxvsbHGJBuJn2rjfQJt3nrkTxjyERFCBH6CRRliCG7BxFf10OH0Ri8dmigR7QsjNyL28lCFdhbJajIECdK93IBceu051tI9IMD6nC75OAkwvZbk2wNop8BIYMTszTLX7IMlwR4z5eudZ2U6bXENbv4jjzoyC0qXznun9l7ov7x9jhk15YLMdr97XFbsJj1aw0L3E";
        output=s.reverseVowels(str);
        Util.verify(expect,output,seq++);

    }
}
