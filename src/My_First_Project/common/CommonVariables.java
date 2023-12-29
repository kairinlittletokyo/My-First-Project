package My_First_Project.common;

import My_First_Project.dto.MemberDTO;

public class CommonVariables {

        public static MemberDTO loggedInMember = null;

        public static MemberDTO getLoggedInMember() {
            return loggedInMember;
        }

        public static void setLoggedInMember(MemberDTO member) {
            loggedInMember = member;
        }

    public static Boolean adminLogin = null;
}

