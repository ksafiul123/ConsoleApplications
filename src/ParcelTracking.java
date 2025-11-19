public class ParcelTracking {
    public static void main(String[] args) {
        String trackingCode = "ID-90345-WEIGHT:25.87";
        String idPart = trackingCode.substring(3,8);
        int trackingID = Integer.parseInt(idPart);
        int nextTrackingID = trackingID+1;
        String weightPart = trackingCode.substring(16,trackingCode.length());
        int weightWithoutDecimal=(int) Double.parseDouble(weightPart);
        System.out.println("Next Tracking ID: "+ nextTrackingID);
        System.out.println("Weight without decimal point "+ weightWithoutDecimal);
    }
}
