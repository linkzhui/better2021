class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0; 
        int[] move = new int[]{0, 0};
        int[] deltaX = new int[]{0, 1, 0, -1}; 
        int[] deltaY = new int[]{1, 0, -1, 0}; 
        for(char ch: instructions.toCharArray()){
            if(ch == 'L'){
                dir = (dir + 3) % 4; 
            } else if(ch == 'R'){
                dir = (dir + 1) % 4;
            } else {
                move[0] += deltaX[dir]; 
                move[1] += deltaY[dir]; 
            }            
        }
        return ( (move[0] == 0 && move[1] == 0) ||
            dir != 0); 
    }
}


