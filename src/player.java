/*import java.util.*;
import java.util.List;
import java.io.FileOutputStream;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;*/

public class player {	
	
	final int CURRENT_POSITION = 0;
	final int WINS_TOTAL = 1;
	final int WINS_CARRY = 2;
	final int WINS_MID = 3;
	final int WINS_OFFLANE = 4;
	final int WINS_SUPPORT4 = 5;
	final int WINS_SUPPORT5 = 6;
	final int WINS_COACH = 7;
	final int GAMES_TOTAL = 8;
	final int GAMES_CARRY = 9;
	final int GAMES_MID = 10;
	final int GAMES_OFFLANE = 11;
	final int GAMES_SUPPORT4 = 12;
	final int GAMES_SUPPORT5 = 13;
	final int GAMES_COACH = 14;
	final int ARRAY_SIZE = 15;
	
	
	
	String playerName;
//	private int winsTotal, wins1, wins2, wins3, wins4, wins5, winsCoach, gamesTotal, games1, games2, games3, games4, games5, gamesCoach, index, active;
	private int [] stats;
	public int flag = 0;
	
	public String nameCheck() {
		return playerName;
	}
	
	
	public player(String n, int [] a) {
		stats = new int[ARRAY_SIZE];
		playerName = n;
		for(int i = 0; i < ARRAY_SIZE ; i++)
		{
			//System.out.println(i);
           stats[i] = a[i];
		}
	/*	winsTotal = 0;
		wins1 = 0;
		wins2 = 0;
		wins3 = 0;
		wins4 = 0;
		wins5 = 0;
		winsCoach = 0;
		gamesTotal = 0;
		games1 = 0;
		games2 = 0;
		games3 = 0;
		games4 = 0;
		games5 = 0;
		gamesCoach = 0;
		index = 0;
		active = 0; */
		}
	
/*	public void setActive()
	{
		 = 1;
		
	}
	*/
	public void setCurrentPosition(int position)
	{
		
		stats[CURRENT_POSITION] = position;
	}
	public void addGame()
	{
		stats[GAMES_TOTAL] += 1;
		switch(stats[0])
		{
		case 0:
			stats[GAMES_CARRY] += 1;
			break;
		case 1:
			stats[GAMES_MID] += 1;
			break;
		case 2:
			stats[GAMES_OFFLANE] += 1;
			break;
		case 3:
			stats[GAMES_SUPPORT4] += 1;
			break;
		case 4:
			stats[GAMES_SUPPORT5] += 1;
			break;
		default:
			stats[GAMES_COACH] += 1;
		}
	}
	public void addWin()
	{
		stats[WINS_TOTAL]+=1;
		switch(stats[0])
		{
		case 0:
			stats[WINS_CARRY] += 1;
			stats[0] = 0;
			break;
		case 1:
			stats[WINS_MID] += 1;
			stats[0] = 0;
			break;
		case 2:
			stats[WINS_OFFLANE] += 1;
			stats[0] = 0;
			break;
		case 3:
			stats[WINS_SUPPORT4] += 1;
			stats[0] = 0;
			break;
		case 4:
			stats[WINS_SUPPORT5] += 1;
			stats[0] = 0;
			break;
		default:
			stats[WINS_COACH] += 1;
			stats[0] = 0;
			break;
		}
	}
	public void clear()
	{
		stats[0]=0;
	}
	
	public String save()
	{
		return playerName + "," + stats[CURRENT_POSITION] + "," + stats[WINS_TOTAL] + "," + stats[WINS_CARRY] + "," + stats[WINS_MID] + "," + stats[WINS_OFFLANE] + "," + stats[WINS_SUPPORT4] + "," + stats[WINS_SUPPORT5] + "," + stats[WINS_COACH] + "," + stats[GAMES_TOTAL] + "," + stats[GAMES_CARRY] + "," + stats[GAMES_MID] + "," + stats[GAMES_OFFLANE] + "," + stats[GAMES_SUPPORT4] + ","+ stats[GAMES_SUPPORT5] + ","+ stats[GAMES_COACH] + ",\n";
	}
	
	public String toString()
	{
		return "Name: "+playerName+"\n\tWins as Carry: "+stats[WINS_CARRY]+"\n\tWins as Mid: "+stats[WINS_MID]+"\n\tWins as Offlane: "+stats[WINS_OFFLANE]+"\n\tWins as 4 Support: "+stats[WINS_SUPPORT4]+"\n\tWins as 5 Support: "+stats[WINS_SUPPORT5]+"\n\tWins as Coach: "+stats[WINS_COACH]+"\n\tPlayed games: "+stats[GAMES_TOTAL]+"\n\tGames as Carry: "+stats[GAMES_CARRY]+"\n\tGames as Mid: "+stats[GAMES_MID]+"\n\tGames as Offlane: "+stats[GAMES_OFFLANE]+"\n\tGames as 4 support: "+stats[GAMES_SUPPORT4]+"\n\tGames as 5 support: "+stats[GAMES_SUPPORT5]+"\n\tGames as Coach: "+stats[GAMES_COACH];
	}
	
/*	public player createPlayer(File f,int n,String name) throws IOException
	{
		File file = f;
		Scanner s;
		try {
			 s = new Scanner(f);
		} catch (FileNotFoundException e1) {
			System.out.println("This bitch got yeeted");
			s = null;
		}
		s.useDelimiter(",|\\n");
		
		for (int i = 0; n<i; i++)
        {
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			s.nextLine();
        }
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter w = new PrintWriter(bw);
		
		w.print(name+",");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,");
		w.print("0,\n");
		w.close();	
		return new player();
	}*/
		
	}


