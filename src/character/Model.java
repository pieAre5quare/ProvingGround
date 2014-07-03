package character;

import java.util.ArrayList;

import main.MainFSM;

public class Model implements IActions
{
	//class
	private String charClass;
	
	//base stats
	private int strength,dexterity,twitch,constitution,intelligence,wisdom,commonSense,spirituality,charisma,luck;
	
	//current stats
	private int cStrength,cDexterity,cTwitch,cConstitution,cIntelligence,cWisdom,cCommonSense,cSpirituality,cCharisma,cLuck;
	
	//other attributes
	private String name, race, gender, alignment, profession; 
	private int age, status, level, xp, rank, gold;
	
	//points c=current m=max
	private int cHitPoints, mHitPoints, cMagicPoints, mMagicPoints, 
	cSkillPoints, mSkillPoints, cPrayerPoints, mPrayerPoints, cBardPoints, mBardPoints;
	
	//armor class b=base, c=current
	private int bArmorClass, cArmorClass;
	
	//number attacks per round
	private int bAttPerRound, cAttPerRound; 
	
	//resurrection modifier
	private double resModifier;
	

	@Override
	public void useWeapon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useMagic() {
		// TODO Auto-generated method stub
		
	}
	
	// method to easily roll all base stats for Model instance
	public void rollBaseStats(int numOfDice,int numOfSides, int modifier)
	{
		this.strength = Const.rollDice(numOfDice,numOfSides,modifier);
		this.dexterity = Const.rollDice(numOfDice, numOfSides,modifier);
		this.twitch = Const.rollDice(numOfDice, numOfSides,modifier);
		this.intelligence = Const.rollDice(numOfDice, numOfSides,modifier);
		this.wisdom = Const.rollDice(numOfDice, numOfSides,modifier);
		this.commonSense = Const.rollDice(numOfDice, numOfSides,modifier);
		this.spirituality = Const.rollDice(numOfDice, numOfSides,modifier);
		this.charisma = Const.rollDice(numOfDice, numOfSides,modifier);
		this.luck = Const.rollDice(numOfDice, numOfSides,modifier);
		this.constitution = Const.rollDice(numOfDice, numOfSides,modifier);
		cStrength = strength;
		cDexterity = dexterity;
		cTwitch = twitch;
		cIntelligence = intelligence;
		cWisdom = wisdom;
		cCommonSense = commonSense;
		cSpirituality = spirituality;
		cCharisma = charisma;
		cLuck = luck;
		cConstitution = constitution;
		findBonus();
	}
	//Finds the correct bonus for race, gender, profession, and alignment. Needs to add age
	private void findBonus() {
		ArrayList<BonusWrapper> bonuses = MainFSM.getBonuses();
		int count = 0; 
		while(bonuses.get(count).getType().contains("Race")) {
			if(bonuses.get(count).getName().contains(race)) {
				addToBase(bonuses.get(count));
			}
			count++;
		}
		while(bonuses.get(count).getType().contains("Gender")) {
			if(bonuses.get(count).getName().contains(gender)) {
				addToBase(bonuses.get(count));
			}
			count++;
		}
		while(bonuses.get(count).getType().contains("Profession")) {
			if(bonuses.get(count).getName().contains(profession)) {
				addToBase(bonuses.get(count));
			}
			count++;
		}
		while(bonuses.get(count).getType().contains("Alignment")) {
			if(bonuses.get(count).getName().contains(alignment)) {
				addToBase(bonuses.get(count));
			}
			count++;
		}
		
	}

	private void addToBase(BonusWrapper toBeAdded) {
		
		cStrength = cStrength + toBeAdded.getSt();
		cDexterity = cDexterity + toBeAdded.getDx();
		cTwitch = cTwitch + toBeAdded.getTw();
		cIntelligence = cIntelligence + toBeAdded.getIn();
		cWisdom = cWisdom + toBeAdded.getWi();
		cCommonSense = cCommonSense + toBeAdded.getCs();
		cSpirituality = cSpirituality + toBeAdded.getSp();
		cCharisma = cCharisma + toBeAdded.getCh();
		cLuck = cLuck + toBeAdded.getLk();
		cConstitution = cConstitution + toBeAdded.getCn();
	}

	// returns mean of base stats
	public double meanBaseStats()
	{
		double mean = (this.strength+this.dexterity+this.twitch+this.intelligence+this.wisdom
				+this.commonSense+this.spirituality+this.charisma+this.luck+this.constitution)/10.0;
		return mean;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getTwitch() {
		return twitch;
	}

	public void setTwitch(int twitch) {
		this.twitch = twitch;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCommonSense() {
		return commonSense;
	}

	public void setCommonSense(int commonSense) {
		this.commonSense = commonSense;
	}

	public int getSpirtuality() {
		return spirituality;
	}

	public void setSpirtuality(int spirtuality) {
		this.spirituality = spirtuality;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getcHitPoints() {
		return cHitPoints;
	}

	public void setcHitPoints(int cHitPoints) {
		this.cHitPoints = cHitPoints;
	}

	public int getmHitPoints() {
		return mHitPoints;
	}

	public void setmHitPoints(int mHitPoints) {
		this.mHitPoints = mHitPoints;
	}

	public int getcMagicPoints() {
		return cMagicPoints;
	}

	public void setcMagicPoints(int cMagicPoints) {
		this.cMagicPoints = cMagicPoints;
	}

	public int getmMagicPoints() {
		return mMagicPoints;
	}

	public void setmMagicPoints(int mMagicPoints) {
		this.mMagicPoints = mMagicPoints;
	}

	public int getcSkillPoints() {
		return cSkillPoints;
	}

	public void setcSkillPoints(int cSkillPoints) {
		this.cSkillPoints = cSkillPoints;
	}

	public int getmSkillPoints() {
		return mSkillPoints;
	}

	public void setmSkillPoints(int mSkillPoints) {
		this.mSkillPoints = mSkillPoints;
	}

	public int getcPrayerPoints() {
		return cPrayerPoints;
	}

	public void setcPrayerPoints(int cPrayerPoints) {
		this.cPrayerPoints = cPrayerPoints;
	}

	public int getmPrayerPoints() {
		return mPrayerPoints;
	}

	public void setmPrayerPoints(int mPrayerPoints) {
		this.mPrayerPoints = mPrayerPoints;
	}

	public int getcBardPoints() {
		return cBardPoints;
	}

	public void setcBardPoints(int cBardPoints) {
		this.cBardPoints = cBardPoints;
	}

	public int getmBardPoints() {
		return mBardPoints;
	}

	public void setmBardPoints(int mBardPoints) {
		this.mBardPoints = mBardPoints;
	}

	public int getbArmorClass() {
		return bArmorClass;
	}

	public void setbArmorClass(int bArmorClass) {
		this.bArmorClass = bArmorClass;
	}

	public int getcArmorClass() {
		return cArmorClass;
	}

	public void setcArmorClass(int cArmorClass) {
		this.cArmorClass = cArmorClass;
	}

	public int getbAttPerRound() {
		return bAttPerRound;
	}

	public void setbAttPerRound(int bAttPerRound) {
		this.bAttPerRound = bAttPerRound;
	}

	public int getcAttPerRound() {
		return cAttPerRound;
	}

	public void setcAttPerRound(int cAttPerRound) {
		this.cAttPerRound = cAttPerRound;
	}

	public double getResModifier() {
		return resModifier;
	}

	public void setResModifier(double resModifier) {
		this.resModifier = resModifier;
	}

	public String getCharClass() {
		return charClass;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public int getcStrength() {
		return cStrength;
	}

	public void setcStrength(int cStrength) {
		this.cStrength = cStrength;
	}

	public int getcDexterity() {
		return cDexterity;
	}

	public void setcDexterity(int cDexterity) {
		this.cDexterity = cDexterity;
	}

	public int getcTwitch() {
		return cTwitch;
	}

	public void setcTwitch(int cTwitch) {
		this.cTwitch = cTwitch;
	}

	public int getcConstitution() {
		return cConstitution;
	}

	public void setcConstitution(int cConstitution) {
		this.cConstitution = cConstitution;
	}

	public int getcIntelligence() {
		return cIntelligence;
	}

	public void setcIntelligence(int cIntelligence) {
		this.cIntelligence = cIntelligence;
	}

	public int getcWisdom() {
		return cWisdom;
	}

	public void setcWisdom(int cWisdom) {
		this.cWisdom = cWisdom;
	}

	public int getcCommonSense() {
		return cCommonSense;
	}

	public void setcCommonSense(int cCommonSense) {
		this.cCommonSense = cCommonSense;
	}

	public int getcSpirituality() {
		return cSpirituality;
	}

	public void setcSpirituality(int cSpirtuality) {
		this.cSpirituality = cSpirtuality;
	}

	public int getcCharisma() {
		return cCharisma;
	}

	public void setcCharisma(int cCharisma) {
		this.cCharisma = cCharisma;
	}

	public int getcLuck() {
		return cLuck;
	}

	public void setcLuck(int cLuck) {
		this.cLuck = cLuck;
	}


}
