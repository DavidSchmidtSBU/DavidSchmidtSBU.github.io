package objectArrays;

public class LineScore
{
    private int runs, hits, errors;
    private String team;
    
    public LineScore(String t, int r, int h, int e)
    {
        team = t;
        runs = r;
        hits = h;
        errors = e;
    }

    public LineScore()
    {
        team = "Team";
        runs = 0;
        hits = 0;
        errors = 0;
    }
    
    //Accessor methods
    public void setTeam(String t)
    {
       team = t;
    }
    
    public void setRuns(int r)
    {
       runs = r;
    }
    
    public void setHits(int h)
    {
       hits = h;
    }
    
    public void setErrors(int e)
    {
       errors = e;
    }
    //Mutator methods
    public String getTeam()
    {
       return team; 
    }
    
    public int getRuns()
    {
       return runs;
    }
    
    public int getHits()
    {
       return hits;
    }
    
    public int getErrors()
    {
       return errors;
    }
}
