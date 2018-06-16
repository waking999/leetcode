package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class StudentAttendanceRecordITest {
    @Test
    public void test1() {
        StudentAttendanceRecordI s = new StudentAttendanceRecordI();

        String str;
        boolean expect;
        boolean output;

        str = "PPALLP";
        expect = true;
        output = s.checkRecord(str);
        verify(expect, output, 1);

        str = "PPALLL";
        expect = false;
        output = s.checkRecord(str);
        verify(expect, output, 2);

    }
}
