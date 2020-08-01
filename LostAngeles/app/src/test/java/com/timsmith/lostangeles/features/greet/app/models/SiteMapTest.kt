package com.timsmith.lostangeles.features.greet.app.models

import org.junit.Before
import org.junit.Test
import java.util.*

class SiteMapTest {

    private val destinationOne = DestinationCampsiteNode(id = 1)
    private val destinationTwo = DestinationCampsiteNode(id = 2)
    private val destinationThree = DestinationCampsiteNode(id = 3)
    private val destinationFour = DestinationCampsiteNode(id = 4)
    private val destinationFive = DestinationCampsiteNode(id = 5)
    private val destinationSix = DestinationCampsiteNode(id = 6)
    private val destinationSeven = DestinationCampsiteNode(id = 7)
    private val destinationEight = DestinationCampsiteNode(id = 8)
    private val destinationNine = DestinationCampsiteNode(id = 9)
    private val destinationTen = DestinationCampsiteNode(id = 10)
    private val destinationEleven = DestinationCampsiteNode(id = 11)
    private val destinationTwelve = DestinationCampsiteNode(id = 12)
    private val destinationThirteen = DestinationCampsiteNode(id = 13)
    private val destinationFourteen = DestinationCampsiteNode(id = 14)
    private val destinationFifteen = DestinationCampsiteNode(id = 15)
    private val destinationSixteen = DestinationCampsiteNode(id = 16)

    private val destinationOneEdges = listOf(destinationThirteen, destinationTwo)
    private val destinationTwoEdges = listOf(destinationThree, destinationOne)
    private val destinationThreeEdges = listOf(destinationTwo, destinationFour)
    private val destinationFourEdges = listOf(destinationFive, destinationThree)
    private val destinationFiveEdges = listOf(destinationFour, destinationSix)
    private val destinationSixEdges = listOf(destinationFive, destinationSeven)
    private val destinationSevenEdges = listOf(destinationSix, destinationEight)
    private val destinationEightEdges = listOf(destinationNine, destinationFourteen)
    private val destinationNineEdges = listOf(destinationEight, destinationTen)
    private val destinationTenEdges = listOf(destinationNine, destinationEleven)
    private val destinationElevenEdges = listOf(destinationTen, destinationTwelve)
    private val destinationTwelveEdges = listOf(destinationEleven, destinationThirteen)
    private val destinationThirteenEdges = listOf(destinationOne, destinationTwelve, destinationSixteen)
    private val destinationFourteenEdges = listOf(destinationEight, destinationFifteen)
    private val destinationFifteenEdges = listOf(destinationFourteen, destinationSixteen)
    private val destinationSixteenEdges = listOf(destinationThirteen, destinationFifteen)

    @Before
    fun setup() {

        destinationOne.routeToNode.routeList.add(destinationOne)
        destinationOne.addEdges(destinationOneEdges)
        destinationTwo.addEdges(destinationTwoEdges)
        destinationThree.addEdges(destinationThreeEdges)
        destinationFour.addEdges(destinationFourEdges)
        destinationFive.addEdges(destinationFiveEdges)
        destinationSix.addEdges(destinationSixEdges)
        destinationSeven.addEdges(destinationSevenEdges)
        destinationEight.addEdges(destinationEightEdges)
        destinationNine.addEdges(destinationNineEdges)
        destinationTen.addEdges(destinationTenEdges)
        destinationEleven.addEdges(destinationElevenEdges)
        destinationTwelve.addEdges(destinationTwelveEdges)
        destinationThirteen.addEdges(destinationThirteenEdges)
        destinationFourteen.addEdges(destinationFourteenEdges)
        destinationFifteen.addEdges(destinationFifteenEdges)
        destinationSixteen.addEdges(destinationSixteenEdges)
    }

    @Test
    fun testGetShortestRouteForSixteen(){
        val expectedRoute = Route(
            LinkedList(
                listOf(
                    destinationOne,
                    destinationThirteen,
                    destinationSixteen
                )
            )
        )
        val route = SiteMap.getShortestRouteFor(16)
        assert(route?.time == expectedRoute.time)
        assert(route == expectedRoute)
    }

    @Test
    fun testGetShortestRouteForFourteen() {
        val expectedRoute = Route(
            LinkedList(
                listOf(
                    destinationOne,
                    destinationThirteen,
                    destinationSixteen,
                    destinationFifteen,
                    destinationFourteen
                )
            )
        )
        val route = SiteMap.getShortestRouteFor(14)
        assert(route?.time == expectedRoute.time)
        assert(route == expectedRoute)
    }

    @Test
    fun testGetShortestRouteForTen() {
        val expectedRoute = Route(
            LinkedList(
                listOf(
                    destinationOne,
                    destinationThirteen,
                    destinationTwelve,
                    destinationEleven,
                    destinationTen
                )
            )
        )
        val route = SiteMap.getShortestRouteFor(10)
        assert(route?.time == expectedRoute.time)
        assert(route == expectedRoute)
    }

    @Test
    fun testGetShortestRouteForFour(){
        val expectedRoute = Route(
            LinkedList(
                listOf(
                    destinationOne,
                    destinationTwo,
                    destinationThree,
                    destinationFour
                )
            )
        )
        val route = SiteMap.getShortestRouteFor(4)
        assert(route?.time == expectedRoute.time)
        assert(route == expectedRoute)
    }
}