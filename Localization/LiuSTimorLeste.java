public class LiuSTimorLeste extends AbstractLocale{
    public LiuSTimorLeste(){
        super("Timor-Leste", "Tetum");
    }

    public LiuSTimorLeste(String location, String language) {
        super(location, language);
    }

    @Override
    public String getLocalTime(int hour, int min){
        // Calendar local = new GregorianCalendar(0, 0, 0, hour, min);
        // Calendar timor = new GregorianCalendar(TimeZone.getTimeZone("Etc/GMT+9"));
        // timor.setTimeInMillis(local.getTimeInMillis());
        // return String.format("%d:%02d", timor.get(Calendar.HOUR), timor.get(Calendar.MINUTE));
        return String.format("%d:%02d", (hour+3)%12, min);
    }

    @Override
    public String getGreeting() {
        return "Elo";
    }

    @Override
    public String getCurrencySymbol() {
        return "$";
    }

    @Override
    public double getCurrencyValue(double dollarAmount) {
        return dollarAmount;
    }
}
