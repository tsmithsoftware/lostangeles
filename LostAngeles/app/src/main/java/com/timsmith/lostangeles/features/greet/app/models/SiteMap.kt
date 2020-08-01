package com.timsmith.lostangeles.features.greet.app.models

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object SiteMap {
    var nodes: HashMap<Int, DestinationCampsiteNode> = HashMap()

    init {
        val destinationOne = DestinationCampsiteNode(id = 1)
        destinationOne.routeToNode.routeList.add(destinationOne)
        val destinationTwo = DestinationCampsiteNode(id = 2)
        val destinationThree = DestinationCampsiteNode(id = 3)
        val destinationFour = DestinationCampsiteNode(id = 4)
        val destinationFive = DestinationCampsiteNode(id = 5)
        val destinationSix = DestinationCampsiteNode(id = 6)
        val destinationSeven = DestinationCampsiteNode(id = 7)
        val destinationEight = DestinationCampsiteNode(id = 8)
        val destinationNine = DestinationCampsiteNode(id = 9)
        val destinationTen = DestinationCampsiteNode(id = 10)
        val destinationEleven = DestinationCampsiteNode(id = 11)
        val destinationTwelve = DestinationCampsiteNode(id = 12)
        val destinationThirteen = DestinationCampsiteNode(id = 13)
        val destinationFourteen = DestinationCampsiteNode(id = 14)
        val destinationFifteen = DestinationCampsiteNode(id = 15)
        val destinationSixteen = DestinationCampsiteNode(id = 16)

        val destinationOneEdges = listOf(destinationThirteen, destinationTwo)
        val destinationTwoEdges = listOf(destinationThree, destinationOne)
        val destinationThreeEdges = listOf(destinationTwo, destinationFour)
        val destinationFourEdges = listOf(destinationFive, destinationThree)
        val destinationFiveEdges = listOf(destinationFour, destinationSix)
        val destinationSixEdges = listOf(destinationFive, destinationSeven)
        val destinationSevenEdges = listOf(destinationSix, destinationEight)
        val destinationEightEdges = listOf(destinationNine, destinationFourteen)
        val destinationNineEdges = listOf(destinationEight, destinationTen)
        val destinationTenEdges = listOf(destinationNine, destinationEleven)
        val destinationElevenEdges = listOf(destinationTen, destinationTwelve)
        val destinationTwelveEdges = listOf(destinationEleven, destinationThirteen)
        val destinationThirteenEdges = listOf(destinationOne, destinationSixteen)
        val destinationFourteenEdges = listOf(destinationEight, destinationFifteen)
        val destinationFifteenEdges = listOf(destinationFourteen, destinationSixteen)
        val destinationSixteenEdges = listOf(destinationThirteen, destinationFifteen)

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


        nodes[1] = destinationOne
        nodes[2] = destinationTwo
        nodes[3] = destinationThree
        nodes[4] = destinationFour
        nodes[5] = destinationFive
        nodes[6] = destinationSix
        nodes[7] = destinationSeven
        nodes[8] = destinationEight
        nodes[9] = destinationNine
        nodes[10] = destinationTen
        nodes[11] = destinationEleven
        nodes[12] = destinationTwelve
        nodes[13] = destinationThirteen
        nodes[14] = destinationFourteen
        nodes[15] = destinationFifteen
        nodes[16] = destinationSixteen
    }

    fun getShortestRouteFor(destinationId: Int): Route? {
        return getShortestRouteFor(nodes[destinationId])
    }

    private fun getShortestRouteFor(destination: DestinationCampsiteNode?): Route? {
        nodes[1]?.let {
            bfs(it)
        }
        destination?.let {
            return nodes[destination.id]?.routeToNode
        }
        return null
    }

    private fun bfs(node: DestinationCampsiteNode) {
        val neighbours: ArrayList<Edge> = node.connectedCampsites
        node.visited = true
        for (i in neighbours.indices) {
            val n: DestinationCampsiteNode? = neighbours[i].end
            n?.let {
                if (!n.visited) {
                    val newRoute = node.routeToNode.deepCopy()
                    newRoute.routeList.add(n)
                    n.routeToNode = newRoute
                }
            }
        }

        for(i in neighbours.indices) {
            neighbours[i].end?.let {
                if (!it.visited) {
                    bfs(it)
                }
            }
        }
    }
}