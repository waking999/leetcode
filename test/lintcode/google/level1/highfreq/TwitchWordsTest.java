package lintcode.google.level1.highfreq;

import common.Util;
import org.junit.jupiter.api.Test;

public class TwitchWordsTest {
    @Test
    public void test1(){
        TwitchWords s=new TwitchWords();

        String str;
        int[][] expect;
        int[][] output;
        int seq=1;

        str="whaaaaatttssup";
        expect=new int[][]{{2,6},{7,9}};
        output=s.twitchWords(str);
        Util.verifyUnsort(expect,output,seq++);

        str="whooooisssbesssst";
        expect=new int[][]{{2,5},{7,9},{12,15}};
        output=s.twitchWords(str);
        Util.verifyUnsort(expect,output,seq++);

        str="llavttupppteewjtooob";
        expect=new int[][]{{7,9},{16,18}};
        output=s.twitchWords(str);
        Util.verifyUnsort(expect,output,seq++);

        str="aecayyxykvwxehojpjjjjjjjjlzmuueywwwwhaqkglarzkoyocjeomzklcavpppppppppppppqbpocmtlxqchewwwbmhaaweippiiiiiihaahhfzfohjzozkbtxiagapicnjpssseirkpoyyyyyyhmvcraaayajpegnbbbbbrekevmnubssukbbbbbbbbbbbbbbbwdnhmwaviofffffffffffffffzusyvehtpppnderovelccceislilewlvffurfmtkwuesyjeeeecmcgwxrrrrrrrrrrrvgejthadmeeeeeeywtwsssscgqptlllllfibiougeeescbhmssbfotmvvuukkkkiaakkmwkabbwyrzacvvvvijrxrteeeeeuwqgehiojjjjjjffffffffcyjqovwqooddddddddppppppppppppiaeaubhjvvvsmaaacpxkebxahwbzxjwnvvvvwmrrmxfqfssshbamebckkactttttmymekcyxxfffffttducelrrofklmmmjnegvcfrhhejyvcewdraaaaaafvkuppppptlqhtqxmmpjgmllllllhdpzptsegctnclurxvvtttpoxwzdwucsyfrtppwcgmqjaezxbgxasrfbbbbbbcrcsslwqiyffzqrjobbbbaifydylkiiiiiiiiiieqqqqqoooogzzzznnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnezztjxzffffffffffffffjfjrpwaaaaaabdalsbllwwieryyyooahhhfrjyaaffkycihcoooeveyzmdauaskpbiabbbbbbbuluyyyyyyyyyyyycyrlmxawnywzyomuunnnnsetsvvxhzaooonzyjgjjapgewnn";
        expect=new int[][]{{17,24},{32,35},{60,72},{86,88},{99,104},{133,135},{142,147},{153,155},{163,167},{181,195},{206,220},{229,231},{240,242},{267,270},{277,287},{297,302},{307,310},{316,320},{328,330},{347,350},{368,371},{378,382},{391,396},{397,404},{415,422},{423,434},{443,445},{448,450},{467,470},{480,482},{494,498},{508,512},{526,528},{548,553},{558,562},{576,581},{601,603},{637,642},{660,663},{672,681},{683,687},{688,691},{693,696},{697,727},{735,748},{755,760},{774,776},{780,782},{797,799},{816,822},{826,837},{855,858},{869,871}};
        output=s.twitchWords(str);
        Util.verifyUnsort(expect,output,seq++);

        str="aqquuuuwwhhhiiiimgyyffffhgyeyyegdvvvvvvvvvhhheiddd";
        expect=new int[][]{{3,6},{9,11},{12,15},{20,23},{33,41},{42,44},{47,49}};
        output=s.twitchWords(str);
        Util.verifyUnsort(expect,output,seq++);
    }
}
