package scala.tools.abide
package traversal

trait WarningRule extends SimpleTraversal with TraversalRule { self : Traversal =>
  import analyzer.global._

  def emptyState = State(Nil)
  case class State(warnings : List[Warning]) extends RuleState {
    def nok(warning : Warning) : State = State(warning :: warnings)
  }

  def nok(warning : Warning) : TraversalStep[Tree, State] = new SimpleStep[Tree, State] {
    val enter = (state : State) => state nok warning
  }
}


// vim: set ts=4 sw=4 et:
