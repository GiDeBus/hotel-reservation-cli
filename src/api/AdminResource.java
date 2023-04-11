package api;

public class AdminResource {
    private static AdminResource adminResource = new AdminResource();
    public static AdminResource getAdminResource() {
        return adminResource;
    }
}
