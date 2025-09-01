//  https://www.fastprep.io/problems/amazon-find-idle-skills-query

import java.util.HashSet;
import java.util.Set;

public class SkillQuerySolver {

    public int[] findIdleSkillsQuery(int numSkills, int[][] requestLogs, int[] queryTimes, int timeWindow) {
        int[] result = new int[queryTimes.length];
        int i = 0;
        
        for (int t : queryTimes) {
            int start = t - timeWindow;
            
            Set<Integer> activeSkills = new HashSet<>();

            for (int[] log : requestLogs) {
                int skillId = log[0];
                int time = log[1]; // Corrected this line

                if (time >= start && time <= t) {
                    activeSkills.add(skillId);
                }
            }
            
            result[i] = numSkills - activeSkills.size();
            i++;
        }

        return result;
    }
}
