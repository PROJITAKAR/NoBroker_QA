package managers;

import org.openqa.selenium.WebDriver;

// EPC
import pageObjects.EPC.AddressPage;
import pageObjects.EPC.DateSlotPage;
import pageObjects.EPC.HomePage;
import pageObjects.EPC.HomeServicesPage;
import pageObjects.EPC.OrderSummaryPage;
import pageObjects.EPC.SubServicesPage;

// PackersAndMovers
import pageObjects.PackersAndMoversPage.InventoryPage;
import pageObjects.PackersAndMoversPage.LocationPage;
import pageObjects.PackersAndMoversPage.MenuPage;
import pageObjects.PackersAndMoversPage.SlotBookingPage;

// PostYourProperty
import pageObjects.PostYourProperty.AmenitiesPage;
import pageObjects.PostYourProperty.LocalityDetailsPage;
import pageObjects.PostYourProperty.NavigationToPostYourProperty;
import pageObjects.PostYourProperty.PostYourPropertyMainPage;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import pageObjects.PostYourProperty.RentalDetailsPage;
import pageObjects.PostYourProperty.SchedulePage;
import pageObjects.PostYourProperty.StartPostingYourAD;
import pageObjects.PostYourProperty.SuccessPage;
import pageObjects.PostYourProperty.UploadMediaPage;

// SearchFilter
import pageObjects.SearchFilterPageObjects.BuyFullHouseFiltering;
import pageObjects.SearchFilterPageObjects.FlatMateResults;
import pageObjects.SearchFilterPageObjects.PGresultsPage;

public class PageObjectManager {

    private WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    // ================= EPC =================
    private AddressPage addressPage;
    public AddressPage addressPage() {
        return (addressPage == null) ? addressPage = new AddressPage(driver) : addressPage;
    }

    private DateSlotPage dateSlotPage;
    public DateSlotPage dateSlotPage() {
        return (dateSlotPage == null) ? dateSlotPage = new DateSlotPage(driver) : dateSlotPage;
    }

    private HomePage homePage;
    public HomePage homePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    private HomeServicesPage homeServicesPage;
    public HomeServicesPage homeServicesPage() {
        return (homeServicesPage == null) ? homeServicesPage = new HomeServicesPage(driver) : homeServicesPage;
    }

    private OrderSummaryPage orderSummaryPage;
    public OrderSummaryPage orderSummaryPage() {
        return (orderSummaryPage == null) ? orderSummaryPage = new OrderSummaryPage(driver) : orderSummaryPage;
    }

    private SubServicesPage subServicesPage;
    public SubServicesPage subServicesPage() {
        return (subServicesPage == null) ? subServicesPage = new SubServicesPage(driver) : subServicesPage;
    }

    // ================= Packers =================
    private InventoryPage inventoryPage;
    public InventoryPage inventoryPage() {
        return (inventoryPage == null) ? inventoryPage = new InventoryPage(driver) : inventoryPage;
    }

    private LocationPage locationPage;
    public LocationPage locationPage() {
        return (locationPage == null) ? locationPage = new LocationPage(driver) : locationPage;
    }

    private MenuPage menuPage;
    public MenuPage menuPage() {
        return (menuPage == null) ? menuPage = new MenuPage(driver) : menuPage;
    }

    private SlotBookingPage slotBookingPage;
    public SlotBookingPage slotBookingPage() {
        return (slotBookingPage == null) ? slotBookingPage = new SlotBookingPage(driver) : slotBookingPage;
    }

    // ================= Post Property =================
    private AmenitiesPage amenitiesPage;
    public AmenitiesPage amenitiesPage() {
        return (amenitiesPage == null) ? amenitiesPage = new AmenitiesPage(driver) : amenitiesPage;
    }

    private LocalityDetailsPage localityDetailsPage;
    public LocalityDetailsPage localityDetailsPage() {
        return (localityDetailsPage == null) ? localityDetailsPage = new LocalityDetailsPage(driver) : localityDetailsPage;
    }

    private NavigationToPostYourProperty navigationPage;
    public NavigationToPostYourProperty navigationPage() {
        return (navigationPage == null) ? navigationPage = new NavigationToPostYourProperty(driver) : navigationPage;
    }

    private PostYourPropertyMainPage mainPage;
    public PostYourPropertyMainPage mainPage() {
        return (mainPage == null) ? mainPage = new PostYourPropertyMainPage(driver) : mainPage;
    }

    private PropertyDetailsPage propertyDetailsPage;
    public PropertyDetailsPage propertyDetailsPage() {
        return (propertyDetailsPage == null) ? propertyDetailsPage = new PropertyDetailsPage(driver) : propertyDetailsPage;
    }

    private RentalDetailsPage rentalDetailsPage;
    public RentalDetailsPage rentalDetailsPage() {
        return (rentalDetailsPage == null) ? rentalDetailsPage = new RentalDetailsPage(driver) : rentalDetailsPage;
    }

    private SchedulePage schedulePage;
    public SchedulePage schedulePage() {
        return (schedulePage == null) ? schedulePage = new SchedulePage(driver) : schedulePage;
    }

    private StartPostingYourAD startPage;
    public StartPostingYourAD startPage() {
        return (startPage == null) ? startPage = new StartPostingYourAD(driver) : startPage;
    }

    private SuccessPage successPage;
    public SuccessPage successPage() {
        return (successPage == null) ? successPage = new SuccessPage(driver) : successPage;
    }

    private UploadMediaPage uploadMediaPage;
    public UploadMediaPage uploadMediaPage() {
        return (uploadMediaPage == null) ? uploadMediaPage = new UploadMediaPage(driver) : uploadMediaPage;
    }

    // ================= Search Filter =================
    private BuyFullHouseFiltering buyFilterPage;
    public BuyFullHouseFiltering buyFilterPage() {
        return (buyFilterPage == null) ? buyFilterPage = new BuyFullHouseFiltering(driver) : buyFilterPage;
    }

    private FlatMateResults flatMateResults;
    public FlatMateResults flatMateResults() {
        return (flatMateResults == null) ? flatMateResults = new FlatMateResults(driver) : flatMateResults;
    }

    private PGresultsPage pgResultsPage;
    public PGresultsPage pgResultsPage() {
        return (pgResultsPage == null) ? pgResultsPage = new PGresultsPage(driver) : pgResultsPage;
    }
}