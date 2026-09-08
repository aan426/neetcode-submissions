class PacificAtlantic{
    private List<List<Integer>> sucessPairs;
    private Set<List<Integer>> pacSet;
    private Set<List<Integer>> atlSet;
    private int[][] heightsCopy;
    public PacificAtlantic(int[][] heights){
        sucessPairs = new ArrayList<>();
        pacSet = new HashSet<>();
        atlSet = new HashSet<>();
        heightsCopy = heights;
    }

    public void searchCells(){
        // for(int row = 0; row < height.length; row++){
        for(int col = 0; col < heightsCopy[0].length; col++){
            dfsPacific(0, col, 0);
            dfsAtlantic(heightsCopy.length -1, col, 0);
        }

        for(int row = 0; row < heightsCopy.length; row++){
            dfsPacific(row, 0, 0);
            dfsAtlantic(row, heightsCopy[0].length -1, 0);
        }
        
        findOverlappingCells();
    }

    private void dfsPacific(int row, int col, int prevHeight){
        List<Integer> coords = new ArrayList<>();
        coords.add(row);
        coords.add(col);

        // System.out.println("Pac: " + row + " " + col);
        if(currCellNotValid(coords, prevHeight, pacSet)){
            return;
        }

        pacSet.add(coords);
        //up, down, left, right
        if(upperNeighborIsValid(row - 1)){
            dfsPacific(row - 1, col, heightsCopy[row][col]);
        }
        if(lowerNeighborIsValid(row + 1)){
            dfsPacific(row + 1, col, heightsCopy[row][col]);
        }
        if(rightNeighborIsValid(col + 1)){
            dfsPacific(row, col + 1, heightsCopy[row][col]);
        }
        if(leftNeighborIsValid(col - 1)){
            dfsPacific(row, col - 1, heightsCopy[row][col]);
        }
    }

    private void dfsAtlantic(int row, int col, int prevHeight){
        List<Integer> coords = new ArrayList<>();
        coords.add(row);
        coords.add(col);
        // System.out.println("Atl: " + row + " " + col);
        if(currCellNotValid(coords, prevHeight, atlSet)){
            return;
        }

        atlSet.add(coords);
        //up, down, left, right
        if(upperNeighborIsValid(row-1)){
            dfsAtlantic(row - 1, col, heightsCopy[row][col]);
        }
        if(lowerNeighborIsValid(row+1)){
            dfsAtlantic(row + 1, col, heightsCopy[row][col]);
        }
        if(rightNeighborIsValid(col+1)){
            dfsAtlantic(row, col + 1, heightsCopy[row][col]);
        }
        if(leftNeighborIsValid(col-1)){
            dfsAtlantic(row, col - 1, heightsCopy[row][col]);
        }
    }

    private boolean currCellNotValid(List<Integer> coords, int prevHeight, Set<List<Integer>> oceanSet){
        return heightsCopy[coords.get(0)][coords.get(1)] < prevHeight || oceanSet.contains(coords) ? true : false;
    }

    private boolean upperNeighborIsValid(int row){
        return row >= 0 ? true : false;
    }
    private boolean lowerNeighborIsValid(int row){
        return row < heightsCopy.length ? true : false;
    }
    private boolean leftNeighborIsValid(int col){
        return col >= 0 ? true : false;
    }
    private boolean rightNeighborIsValid(int col){
        return col < heightsCopy[0].length ? true : false;
    }

    private void findOverlappingCells(){
        pacSet.retainAll(atlSet);

        for(List<Integer> overLappingCoords : pacSet){
            sucessPairs.add(overLappingCoords);
        }

    }

    public List<List<Integer>> getSucessPairs(){
        return sucessPairs;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        PacificAtlantic pacAtl = new PacificAtlantic(heights);
        pacAtl.searchCells();
        return pacAtl.getSucessPairs();
    }
}
